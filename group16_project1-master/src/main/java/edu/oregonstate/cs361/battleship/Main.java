package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import spark.Request;
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
        return null;
    }

    //This controller should take a json object from the front end, and place the ship as requested, and then return the object.
    private static String placeShip(Request req) {
        int startRow, startCol, endRow, endCol;
        int shipLength = 0;
        int idNum = 0;
        String orientation;
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
        orientation = req.params(":id");

        //Check if ship is a Submarine, if true store the length associated with it
        if(shipId == "submarine") {
            shipLength = 3;
            idNum = 5;
        }
        //Check if ship is a Destroyer, if true store the length associated with it
        if(shipId == "destroyer") {
            shipLength = 2;
            idNum = 4;
        }
        //Check if ship is a Cruiser, if true store the length associated with it
        if(shipId == "cruiser") {
            shipLength = 3;
            idNum = 3;
        }
        //Check if ship is a Battleship, if true store the length associated with it
        if(shipId == "battleship") {
            shipLength = 4;
            idNum = 2;
        }
        //Check if ship is a Aircraft Carrier, if true store the length associated with it
        if(shipId == "aircraftCarrier") {
            shipLength = 5;
            idNum = 1;
        }

        //if orientation is vertical, add ship length to starting row to get ending row
        if(orientation == "vertical") {
            endRow = startRow + shipLength;
            endCol = startCol;

            //check if ending row and col are within game board(10x10)
            if(endRow <= 10 || endCol <= 10) {
                //place ship across
                model.setStartPositionAcross(idNum, startRow);//
            }
            else
            {
                return "Invaild";
            }
        }
        //otherwise assume horizontal, add ship length to starting column to get ending column
        else {
            endRow = startRow;
            endCol = startCol + shipLength;

            //check if ending row and col are within game board(10x10)
            if(endRow <= 10 || endCol <= 10) {
                //place ship downwards
                model.setStartPositionDown(idNum, startCol);
            }
            else
            {
                return "Invaild";
            }
        }

        return "SHIP";
    }

    //Similar to placeShip, but with firing.
    private static String fireAt(Request req) {
        return null;
    }

}