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
    public void setStartPosition(int shipID, int x, int y){
        if(shipID == 1){
            playerAircraft.setAcross(x);
            playerAircraft.setDown(y);

        }else if(shipID == 2){
            playerBattleship.setAcross(x);
            playerBattleship.setDown(y);

        }else if(shipID == 3){
            playerCruiser.setAcross(x);
            playerCruiser.setDown(y);

        }else if(shipID == 4){
            playerDestroyer.setAcross(x);
            playerDestroyer.setDown(y);

        }else if(shipID == 5){
            playerSub.setAcross(x);
            playerSub.setDown(y);

        }else if(shipID == 6){
            computerAircraft.setAcross(x);
            computerAircraft.setDown(y);

        }else if(shipID == 7){
            computerBattleship.setAcross(x);
            computerBattleship.setDown(y);

        }else if(shipID == 8){
            computerCruiser.setAcross(x);
            computerCruiser.setDown(y);

        }else if(shipID == 9){
            computerDestroyer.setAcross(x);
            computerDestroyer.setDown(y);

        }else if(shipID == 10){
            computerSub.setAcross(x);
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

    //GET FUNCTIONS
    public int getHit(){
        return hit;
    }

    public int getMiss(){
        return miss;
    }

    //Player Aircraft get functions
    public int getPlayerAircraftStartAcross(){
        return playerAircraft.getStartAcross();
    }

    public int getPlayerAircraftStartDown(){
        return playerAircraft.getStartDown();
    }

    public int getPlayerAircraftEndAcross(){
        return playerAircraft.getEndAcross();
    }

    public int getPlayerAircraftEndDown(){
        return playerAircraft.getEndDown();
    }

    public int getPlayerAircraftLength(){
        return playerAircraft.getLength();
    }

    //Player Battleship get functions
    public int getPlayerBattleshipStartAcross(){
        return playerBattleship.getStartAcross();
    }

    public int getPlayerBattleshipStartDown(){
        return playerBattleship.getStartDown();
    }

    public int getPlayerBattleshipEndAcross(){
        return playerBattleship.getEndAcross();
    }

    public int getPlayerBattleshipEndDown(){
        return playerBattleship.getEndDown();
    }

    public int getPlayerBattleshipLength(){
        return playerBattleship.getLength();
    }

    //Player Cruiser get functions
    public int getPlayerCruiserStartAcross(){
        return playerCruiser.getStartAcross();
    }

    public int getPlayerCruiserStartDown(){
        return playerCruiser.getStartDown();
    }

    public int getPlayerCruiserEndAcross(){
        return playerCruiser.getEndAcross();
    }

    public int getPlayerCruiserEndDown(){
        return playerCruiser.getEndDown();
    }

    public int getPlayerCruiserLength(){
        return playerCruiser.getLength();
    }

    //Player Destroyer get functions
    public int getPlayerDestroyerStartAcross(){
        return playerDestroyer.getStartAcross();
    }

    public int getPlayerDestroyerStartDown(){
        return playerDestroyer.getStartDown();
    }

    public int getPlayerDestroyerEndAcross(){
        return playerDestroyer.getEndAcross();
    }

    public int getPlayerDestroyerEndDown(){
        return playerDestroyer.getEndDown();
    }

    public int getPlayerDestroyerLength(){
        return playerDestroyer.getLength();
    }

    //Player Submarine get functions
    public int getPlayerSubmarineStartAcross(){
        return playerSub.getStartAcross();
    }

    public int getPlayerSubmarineStartDown(){
        return playerSub.getStartDown();
    }

    public int getPlayerSubmarineEndAcross(){
        return playerSub.getEndAcross();
    }

    public int getPlayerSubmarineEndDown(){
        return playerSub.getEndDown();
    }

    public int getPlayerSubmarineLength(){
        return playerSub.getLength();
    }

    //Computer Aircraft get functions
    public int getComputerAircraftStartAcross(){
        return computerAircraft.getStartAcross();
    }

    public int getComputerAircraftStartDown(){
        return computerAircraft.getStartDown();
    }

    public int getComputerAircraftEndAcross(){
        return computerAircraft.getEndAcross();
    }

    public int getComputerAircraftEndDown(){
        return computerAircraft.getEndDown();
    }

    public int getComputerAircraftLength(){
        return computerAircraft.getLength();
    }

    //Computer Battleship get functions
    public int getComputerBattleshipStartAcross(){
        return computerBattleship.getStartAcross();
    }

    public int getComputerBattleshipStartDown(){
        return computerBattleship.getStartDown();
    }

    public int getComputerBattleshipEndAcross(){
        return computerBattleship.getEndAcross();
    }

    public int getComputerBattleshipEndDown(){
        return computerBattleship.getEndDown();
    }

    public int getComputerBattleshipLength(){
        return computerBattleship.getLength();
    }


    //Computer Cruiser get functions
    public int getComputerCruiserStartAcross(){
        return computerCruiser.getStartAcross();
    }

    public int getComputerCruiserStartDown(){
        return computerCruiser.getStartDown();
    }

    public int getComputerCruiserEndAcross(){
        return computerCruiser.getEndAcross();
    }

    public int getComputerCruiserEndDown(){
        return computerCruiser.getEndDown();
    }

    public int getComputerCruiserLength(){
        return computerCruiser.getLength();
    }


    //Computer Destroyer get functions
    public int getComputerDestroyerStartAcross(){
        return computerDestroyer.getStartAcross();
    }

    public int getComputerDestroyerStartDown(){
        return computerDestroyer.getStartDown();
    }

    public int getComputerDestroyerEndAcross(){
        return computerDestroyer.getEndAcross();
    }

    public int getComputerDestroyerEndDown(){
        return computerDestroyer.getEndDown();
    }

    public int getComputerDestroyerLength(){
        return computerDestroyer.getLength();
    }


    //Computer Submarine get functions
    public int getComputerSubmarineStartAcross(){
        return computerSub.getStartAcross();
    }

    public int getComputerSubmarineStartDown(){
        return computerSub.getStartDown();
    }

    public int getComputerSubmarineEndAcross(){
        return computerSub.getEndAcross();
    }

    public int getComputerSubmarineEndDown(){
        return computerSub.getEndDown();
    }

    public int getComputerSubmarineLength(){
        return computerSub.getLength();
    }

}
