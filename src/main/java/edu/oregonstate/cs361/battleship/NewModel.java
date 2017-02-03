package edu.oregonstate.cs361.battleship;

/**
 * Created by Jacob Geddings on 2/2/2017.
 */
public class NewModel {
    //PRIVATE PC SHIPS
    private Vessel playerAircraft;
    private Vessel playerBattleship;
    private Vessel playerCruiser;
    private Vessel playerDestroyer;
    private Vessel playerSub;

    //PRIVATE COMP SHIPS
    private Vessel computerAircraft;
    private Vessel computerBattleship;
    private Vessel computerCruiser;
    private Vessel computerDestroyer;
    private Vessel computerSub;

    //PRIVATE VARIABLES FOR SCORE
    private int hit;
    private int miss;

    //DEFAULT CONSTRUCTOR
    //Assign basic attributes to ships + default locations
    public NewModel(){
        //player ships assigned their default values
        playerAircraft = new Vessel(1);
        playerBattleship = new Vessel(2);
        playerCruiser = new Vessel(3);
        playerDestroyer = new Vessel(4);
        playerSub = new Vessel(5);

        //computer ships assigned their default values
        computerAircraft = new Vessel(6);
        computerBattleship = new Vessel(7);
        computerCruiser = new Vessel(8);
        computerDestroyer = new Vessel(9);
        computerSub = new Vessel(10);
    }

    //SET FUNCTIONS
    public void setStartPositionAcross(int shipID, int x){
        if(shipID == 1){
            playerAircraft.setAcross(x);

        }else if(shipID == 2){
            playerBattleship.setAcross(x);

        }else if(shipID == 3){
            playerCruiser.setAcross(x);

        }else if(shipID == 4){
            playerDestroyer.setAcross(x);

        }else if(shipID == 5){
            playerSub.setAcross(x);

        }else if(shipID == 6){
            computerAircraft.setAcross(x);

        }else if(shipID == 7){
            computerBattleship.setAcross(x);

        }else if(shipID == 8){
            computerCruiser.setAcross(x);

        }else if(shipID == 9){
            computerDestroyer.setAcross(x);

        }else if(shipID == 10){
            computerSub.setAcross(x);
        }
    }

    public void setStartPositionDown(int shipID, int y){
        if(shipID == 1){
            playerAircraft.setDown(y);

        }else if(shipID == 2){
            playerBattleship.setDown(y);

        }else if(shipID == 3){
            playerCruiser.setDown(y);

        }else if(shipID == 4){
            playerDestroyer.setDown(y);

        }else if(shipID == 5){
            playerSub.setDown(y);

        }else if(shipID == 6){
            computerAircraft.setDown(y);

        }else if(shipID == 7){
            computerBattleship.setDown(y);

        }else if(shipID == 8){
            computerCruiser.setDown(y);

        }else if(shipID == 9){
            computerDestroyer.setDown(y);

        }else if(shipID == 10) {
            computerSub.setDown(y);
        }
    }

    //When called hit tally will increment by one
    public void setHit(){
        hit = hit++;
    }

    //When called miss tally will increment by one
    public void setMiss(){
        miss = miss++;
    }

    //get functions
    public int getHit(){
        return hit;
    }

    public int getMiss(){
        return miss;
    }

    //GET COMMANDS FOR SHIP LENGTHS
    //Player Aircraft get functions
    public int getPlayerAircraftStart(){
        return playerAircraft.getStart();
    }

    public int getPlayerAircraftEnd(){
        return playerAircraft.getEnd();
    }

    public int getPlayerAircraftLength(){
        return playerAircraft.getLength();
    }

    //Player Battleship get functions
    public int getPlayerBattleshipStart(){
        return playerBattleship.getStart();
    }

    public int getPlayerBattleshipEnd(){
        return playerBattleship.getEnd();
    }

    public int getPlayerBattleshipLength(){
        return playerBattleship.getLength();
    }

    //Player Cruiser get functions
    public int getPlayerCruiserStart(){
        return playerCruiser.getStart();
    }

    public int getPlayerCruiserEnd(){
        return playerCruiser.getEnd();
    }

    public int getPlayerCruiserLength(){
        return playerCruiser.getLength();
    }

    //Player Destroyer get functions
    public int getPlayerDestroyerStart(){
        return playerDestroyer.getStart();
    }

    public int getPlayerDestroyerEnd(){
        return playerCruiser.getEnd();
    }

    public int getPlayerDestroyerLength(){
        return playerDestroyer.getLength();
    }

    //Player Submarine get functions
    public int getPlayerSubmarineStart(){
        return playerSub.getStart();
    }

    public int getPlayerSubmarineEnd(){
        return playerSub.getEnd();
    }

    public int getPlayerSubmarineLength(){
        return playerSub.getLength();
    }

    //Computer Aircraft get functions
    public int getComputerAircraftStart(){
        return computerAircraft.getStart();
    }

    public int getComputerAircraftEnd(){
        return computerAircraft.getEnd();
    }

    public int getComputerAircraftLength(){
        return computerAircraft.getLength();
    }

    //Computer Battleship get functions
    public int getComputerBattleshipStart(){
        return computerBattleship.getStart();
    }

    public int getComputerBattleshipEnd(){
        return computerBattleship.getEnd();
    }

    public int getComputerBattleshipLength(){
        return computerBattleship.getLength();
    }

    //Computer Cruiser get functions
    public int getComputerCruiserStart(){
        return computerCruiser.getStart();
    }

    public int getComputerCruiserEnd(){
        return computerCruiser.getEnd();
    }
    public int getComputerCruiserLength(){
        return computerCruiser.getLength();
    }

    //Computer Destroyer get functions
    public int getComputerDestroyerStart(){
        return computerDestroyer.getStart();
    }

    public int getComputerDestroyerEnd(){
        return computerDestroyer.getEnd();
    }

    public int getComputerDestroyerLength(){
        return computerDestroyer.getLength();
    }

    //Computer Submarine get functions
    public int getComputerSubmarineStart(){
        return computerSub.getStart();
    }

    public int getComputerSubmarineEnd(){
        return computerSub.getEnd();
    }
    public int getComputerSubLength(){
        return computerSub.getLength();
    }
}
