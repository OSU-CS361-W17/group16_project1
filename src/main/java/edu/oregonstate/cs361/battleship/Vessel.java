package edu.oregonstate.cs361.battleship;

/**
 * Created by Jacob Geddings on 2/2/2017.
 */
public class Vessel {
    //Characteristics of ships
    int horizontal;     //Set to 0 for horizontal positioning, 1 for vertical
    int startAcross;    //Starting position's x-coordinate
    int startDown;      //Starting position's y-coordinate
    int length;         //Length of the given ship
    String name;        //Name of given ship

    //Not directly linked with classes
    int endAcross;      //Ending position for x-coordinate
    int endDown;        //Ending position for y-coordinate

    //DEFAULT CONSTRUCTOR
    //Default start positions set to -1 for test coverage
    public Vessel(int shipType){
        if(shipType == 1){
            startAcross= -1;
            startDown= -1;
            length = 5;
            name = "Aircraft Carrier";

        }else if(shipType == 2){
            startAcross= -1;
            startDown= -1;
            length = 4;
            name = "Battleship";

        }else if(shipType == 3){
            startAcross= -1;
            startDown= -1;
            length = 3;
            name = "Cruiser";

        }else if(shipType == 4){
            startAcross= -1;
            startDown= -1;
            length = 2;
            name = "Destroyer";

        }else if(shipType == 5){
            startAcross= -1;
            startDown= -1;
            length = 2;
            name = "Submarine";

        }else if(shipType == 6){
            startAcross= -1;
            startDown= -1;
            length = 5;
            name = "Aircraft Carrier";

        }else if(shipType == 7){
            startAcross= -1;
            startDown= -1;
            length = 4;
            name = "Battleship";

        }else if(shipType == 8){
            startAcross= -1;
            startDown= -1;
            length = 3;
            name = "Cruiser";

        }else if(shipType == 9){
            startAcross= -1;
            startDown= -1;
            length = 2;
            name = "Destroyer";

        }else if(shipType == 10){
            startAcross= -1;
            startDown= -1;
            length = 2;
            name = "Submarine";

        }else{
            //should a value other than 1-10 be inputted, assume failure state.
            startAcross= -1;
            startDown= -1;
            length = -1;
            name = "DEAD";
        }
    }

    //SET FUNCTIONS
    //Val of 0 is horizontal alignment, 1 is vertical.
    public void setHorizontal(int val){
        horizontal = val;
    }

    //Set x-coordinate of start position
    public void setAcross(int x){
        startAcross = x;
    }

    //Set y-coordinate of start position
    public void setDown(int y){
        startDown = y;
    }

    //GET FUNCTIONS
    //Retrieve x-coordinate of starting position
    public int getStartAcross(){
        return startAcross;
    }

    //Retrieve y-coordinate of start position
    public int getStartDown(){
        return startDown;
    }

    //If horizontally placed get end coordinate for x
    public int getEndAcross(){
        int endAcrossTemp = startAcross;
        if(horizontal == 0){
            endAcrossTemp = startAcross + length;
        }
        return endAcrossTemp;
    }

    //If vertically placed get end coordinate for y
    public int getEndDown(){
        int endDownTemp = startDown;
        if(horizontal == 1){
            endDownTemp = startDown + length;
        }
        return endDownTemp;
    }

    public int getLength(){
        return length;
    }
}
