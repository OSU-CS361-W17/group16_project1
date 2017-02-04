<<<<<<< HEAD
package edu.oregonstate.cs361.battleship;

/**
 * Created by Jacob Geddings on 2/2/2017.
 */
public class Vessel {
    int acrossSet;
    int downSet;
    int startAcross;
    int startDown;
    int endAcross;
    int endDown;
    int length;
    String name;

    //DEFAULT CONSTRUCTOR
    public Vessel(int shipType){
        if(shipType == 1){
            length = 5;
            name = "Aircraft Carrier";

        }else if(shipType == 2){
            length = 4;
            name = "Battleships";

        }else if(shipType == 3){
            length = 3;
            name = "Cruiser";

        }else if(shipType == 4){
            length = 2;
            name = "Destroyer";

        }else if(shipType == 5){
            length = 2;
            name = "Submarine";

        }else if(shipType == 6){
            length = 5;
            name = "Aircraft Carrier";

        }else if(shipType == 7){
            length = 4;
            name = "Battleship";

        }else if(shipType == 8){
            length = 3;
            name = "Cruiser";

        }else if(shipType == 9){
            length = 2;
            name = "Destroyer";

        }else if(shipType == 10){
            length = 2;
            name = "Submarine";

        }else{
            //should a value other than 1-10 be inputted, assume failure state.
            length = -1;
            name = "DEAD";
        }
    }

    public void setAcross(int x){
        startAcross = x;
        endAcross = x + length;
        acrossSet = 1;
        downSet = 0;
    }

    public void setDown(int y){
        startDown = y;
        endDown = y + length;
        downSet = 1;
        acrossSet = 0;
    }

    public int getStart(){
        int temp = 0;
        if(acrossSet == 1){
            temp = startAcross;
        }else if(downSet == 1){
            temp = startDown;
        }
        return temp;
    }

    public int getEnd(){
        int temp = 0;
        if(acrossSet == 1){
            temp = endAcross;
        }else if(downSet == 1){
            temp = endDown;
        }
        return temp;
    }

    public int getLength(){
        return length;
    }
}
=======
package edu.oregonstate.cs361.battleship;

/**
 * Created by Jacob Geddings on 2/2/2017.
 */
public class Vessel {
    int acrossSet;
    int downSet;
    int startAcross;
    int startDown;
    int endAcross;
    int endDown;
    int length;
    String name;

    //DEFAULT CONSTRUCTOR
    public Vessel(int shipType){
        if(shipType == 1){
            length = 5;
            name = "Aircraft Carrier";

        }else if(shipType == 2){
            length = 4;
            name = "Battleships";

        }else if(shipType == 3){
            length = 3;
            name = "Cruiser";

        }else if(shipType == 4){
            length = 2;
            name = "Destroyer";

        }else if(shipType == 5){
            length = 2;
            name = "Submarine";

        }else if(shipType == 6){
            length = 5;
            name = "Aircraft Carrier";

        }else if(shipType == 7){
            length = 4;
            name = "Battleship";

        }else if(shipType == 8){
            length = 3;
            name = "Cruiser";

        }else if(shipType == 9){
            length = 2;
            name = "Destroyer";

        }else if(shipType == 10){
            length = 2;
            name = "Submarine";

        }else{
            //should a value other than 1-10 be inputted, assume failure state.
            length = -1;
            name = "DEAD";
        }
    }

    public void setAcross(int x){
        startAcross = x;
        endAcross = x + length;
        acrossSet = 1;
        downSet = 0;
    }

    public void setDown(int y){
        startDown = y;
        endDown = y + length;
        downSet = 1;
        acrossSet = 0;
    }

    public int getStart(){
        int temp = 0;
        if(acrossSet == 1){
            temp = startAcross;
        }else if(downSet == 1){
            temp = startDown;
        }
        return temp;
    }

    public int getEnd(){
        int temp = 0;
        if(acrossSet == 1){
            temp = endAcross;
        }else if(downSet == 1){
            temp = endDown;
        }
        return temp;
    }

    public int getLength(){
        return length;
    }
}
>>>>>>> refs/remotes/OSU-CS361-W17/master
