package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import spark.Request;

import java.awt.*;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class Main {

    public static void main(String[] args) {
        //This will allow us to server the static pages such as index.html, app.js, etc.
        staticFiles.location("/public");

        //This will listen to GET requests to /model and return a clean new model
        get("/model", (req, res) -> newModel());
        //This will listen to POST requests and expects to receive a game model, as well as location to fire to
        post("/fire/:row/:col", (req, res) -> fireAt(req));
        //This will listen to POST requests and expects to receive a game model, as well as location to place the ship
        post("/placeShip/:id/:row/:col/:orientation", (req, res) -> placeShip(req));
    }

    //This function should return a new model
    static String newModel() {

        //roster for ships -- get current copy of NewModel class
        NewModel access00;
        access00 = new NewModel();

        //assert that NewModel copy isn't a dud

        //flagged as always true by IntelliJ
        assert access00 != null;

        //convert to json
        Gson gson = new Gson();
        String json00;
        json00 = gson.toJson(access00);

        //assert that json serialization isn't a dud
        assert json00 != null;

        //game is now updated with with current status via json
        return json00;
    }

    //This function should accept an HTTP request and deseralize it into an actual Java object.
    private static BattleshipModel getModelFromReq(Request req){
        //http request, req is a spark request
        String info = req.body();

        //deserialise it into a java object
        Gson gson = new Gson();
        BattleshipModel mod = gson.fromJson(info, BattleshipModel.class);

        return mod;
    }

    //This controller should take a json object from the front end, and place the ship as requested, and then return the object.
    private static String placeShip(Request req) {
        int startRow, startCol, endRow, endCol;
        int shipLength;
        int idNum = 0;
        String orientation = "";
        NewModel model= new NewModel();

        //Get the model from and turn it into a java object
        BattleshipModel newModel = getModelFromReq(req);

        //Get id of ship requested
        String shipId = req.params(":id");
        //Get starting row of ship requested
        startRow = Integer.parseInt(req.params(":row"));
        //Get starting col of ship requested
        startCol = Integer.parseInt(req.params(":col"));
        //Get the orientation of the ship requested
        orientation = req.params(":orientation");

        shipLength = getShipLength(shipId);
        idNum = getIdNum(shipId);
        System.out.println("ID: " + shipId);
        System.out.println(orientation);
        System.out.println("length: " + shipLength);

        //if orientation is vertical, add ship length to starting row to get ending row
        if(orientation.equals("vertical")) {
            endRow = (startRow + shipLength);
            endCol = startCol;

            System.out.println(startRow);
            System.out.println(startCol);

            System.out.println(endRow);
            System.out.println(endCol);

            //Check if ending row and col are within game board(10x10)
            if(endRow <= 10 || endCol <= 10) {
                //place ship across
                model.setStartPosition(idNum, startCol, startRow);
            }
            else
            {
                return "Invalid";
            }
        }
        //Check if horizontal, add ship length to starting column to get ending column
        else if(orientation.equals("horizontal")) {
            endRow = startRow;
            endCol = startCol + shipLength;

            //check if ending row and col are within game board(10x10)
            if(endRow <= 10 || endCol <= 10) {
                //place ship downwards
                model.setStartPosition(idNum, startCol, startRow);
            }
            else
            {
                return "Invalid";
            }
        }

        //
        return "SHIP";
    }

    public static int getShipLength(String shipId){
        int shipLength = 0;
        //Check if ship is a Submarine, if true store the length associated with it
        if(shipId.equals("submarine")){
            shipLength = 3;
        }
        //Check if ship is a Destroyer, if true store the length associated with it
        if(shipId.equals("destroyer")){
            shipLength = 2;
        }
        //Check if ship is a Cruiser, if true store the length associated with it
        if(shipId.equals("cruiser")) {
            shipLength = 3;
        }
        //Check if ship is a Battleship, if true store the length associated with it
        if(shipId.equals("battleship")) {
            shipLength = 4;
        }
        //Check if ship is a Aircraft Carrier, if true store the length associated with it
        if(shipId.equals("aircraftCarrier")) {
            shipLength = 5;
        }
        System.out.println("length: " + shipLength);
        return shipLength;
    }

    public static int getIdNum(String shipId) {
        int idNum = 0;
        //Check if ship is a Submarine, if true store the length associated with it
        if(shipId == "submarine") {
            idNum = 5;
        }
        //Check if ship is a Destroyer, if true store the length associated with it
        if(shipId == "destroyer") {
            idNum = 4;
        }
        //Check if ship is a Cruiser, if true store the length associated with it
        if(shipId == "cruiser") {
            idNum = 3;
        }
        //Check if ship is a Battleship, if true store the length associated with it
        if(shipId == "battleship") {
            idNum = 2;
        }
        //Check if ship is a Aircraft Carrier, if true store the length associated with it
        if(shipId == "aircraftCarrier") {
            idNum = 1;
        }
        return idNum;
    }

    //Similar to placeShip, but with firing.
    private static String fireAt(Request req) {
        int firerow, firecol;
        BattleshipModel gamestate = getModelFromReq(req);
        NewModel model = new NewModel();
        firerow = Integer.parseInt(req.params(":row"));
        firecol = Integer.parseInt(req.params(":col"));
        Point firepoint = new Point(firerow, firecol);

        //generate points for checkhits boolean
        Point playerAircraftstarts = new Point(model.getPlayerAircraftStartAcross(),model.getPlayerAircraftStartDown());
        Point playerAircraftends = new Point(model.getPlayerAircraftEndAcross(),model.getPlayerAircraftEndDown());

        Point playerBattleshipstarts = new Point(model.getPlayerBattleshipStartAcross(),model.getPlayerBattleshipStartDown());
        Point playerBattleshipends = new Point(model.getPlayerBattleshipEndAcross(),model.getPlayerBattleshipEndDown());

        Point playerCruiserstarts = new Point(model.getPlayerCruiserStartAcross(),model.getPlayerCruiserStartDown());
        Point playerCruiserends = new Point(model.getPlayerCruiserEndAcross(),model.getPlayerCruiserEndDown());

        Point playerDestroyerstarts = new Point(model.getPlayerDestroyerStartAcross(),model.getPlayerDestroyerStartDown());
        Point playerDestroyerends = new Point(model.getPlayerDestroyerEndAcross(),model.getPlayerDestroyerEndDown());

        Point playerSubmarinestarts = new Point(model.getPlayerSubmarineStartAcross(),model.getPlayerSubmarineStartDown());
        Point playerSubmarineends = new Point(model.getPlayerSubmarineEndAcross(),model.getPlayerSubmarineEndDown());

        //AI points
        Point ComputerAircraftstarts = new Point(model.getComputerAircraftStartAcross(),model.getComputerAircraftStartDown());
        Point ComputerAircraftends = new Point(model.getComputerAircraftEndAcross(),model.getComputerAircraftEndDown());

        Point ComputerBattleshipstarts = new Point(model.getComputerBattleshipStartAcross(),model.getComputerBattleshipStartDown());
        Point ComputerBattleshipends = new Point(model.getComputerBattleshipEndAcross(),model.getComputerBattleshipEndDown());

        Point ComputerCruiserstarts = new Point(model.getComputerCruiserStartAcross(),model.getComputerCruiserStartDown());
        Point ComputerCruiserends = new Point(model.getComputerCruiserEndAcross(),model.getComputerCruiserEndDown());

        Point ComputerDestroyerstarts = new Point(model.getComputerDestroyerStartAcross(),model.getComputerDestroyerStartDown());
        Point ComputerDestroyerends = new Point(model.getComputerDestroyerEndAcross(),model.getComputerDestroyerEndDown());

        Point ComputerSubmarinestarts = new Point(model.getComputerSubmarineStartAcross(),model.getComputerSubmarineStartDown());
        Point ComputerSubmarineends = new Point(model.getComputerSubmarineEndAcross(),model.getComputerSubmarineEndDown());

        //call the boolean to check if it hits or misses to update player_hit or player_miss
        if(checkhits(firepoint,playerAircraftstarts , playerAircraftends)){
            model.setplayerHit();
            model.getplayerHit();
        }else if(checkhits(firepoint, playerBattleshipstarts, playerBattleshipends)){
            model.setplayerHit();
            model.getplayerHit();
        }else if(checkhits(firepoint, playerCruiserstarts, playerCruiserends)){
            model.setplayerHit();
            model.getplayerHit();
        }else if(checkhits(firepoint, playerDestroyerstarts, playerDestroyerends)){
            model.setplayerHit();
            model.getplayerHit();
        }else if(checkhits(firepoint, playerSubmarinestarts, playerSubmarineends)){
            model.setplayerHit();
            model.getplayerHit();
        }else
            model.setplayerMiss();
            model.getplayerMiss();


        //AI turn:
        Point AIfire = new Point(2, 2);
        //call the boolean to check if it hits or misses to update AI_hit or AI_miss
        if(checkhits(firepoint,ComputerAircraftstarts , ComputerAircraftends)){
            model.setAIHit();
            model.getAIHit();
        }else if(checkhits(firepoint, ComputerBattleshipstarts, ComputerBattleshipends)){
            model.setAIHit();
            model.getAIHit();
        }else if(checkhits(firepoint, ComputerCruiserstarts, ComputerCruiserends)){
            model.setAIHit();
            model.getAIHit();
        }else if(checkhits(firepoint, ComputerDestroyerstarts, ComputerDestroyerends)){
            model.setAIHit();
            model.getAIHit();
        }else if(checkhits(firepoint, ComputerSubmarinestarts, ComputerSubmarineends)){
            model.setAIHit();
            model.getAIHit();
        }else
            model.setAIMiss();
            model.getAIMiss();

        return "hit";
    }

    public static boolean checkhits(Point thisshot, Point starts, Point ends){
        boolean missing = false;
        if (thisshot.x == starts.x ){
            if (thisshot.y <= ends.y && thisshot.y >= starts.y){
                return true;
            }
        }else if(thisshot.y == starts.y){
            if (thisshot.x <= ends.x && thisshot.x >= starts.x) {
                return true;
            }
        }
        return missing;
    }


}

