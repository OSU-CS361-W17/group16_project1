package edu.oregonstate.cs361.battleship;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by Jiayu on 2017-01-30.
 */

public class fireAt {

    //get the fire point and the game state


    public void checkships(int x, int y){
        int i;
        i = 1;
        NewModel nModel = new NewModel();
        Point hitpoint =new Point(x,y);
        NewModel P_Aircraft = nModel.getPlayerAircraft();
        NewModel C_Aircraft = nModel.getComputerAircraft();
        NewModel P_Battleship = nModel.getPlayerBattleship();
        NewModel C_Battleship = nModel.getComputerBattleship();
        NewModel P_Cruiser = nModel.getPlayerCruiser();
        NewModel C_Cruiser = nModel.getComputerCruiser();
        NewModel P_Destroyer = nModel.getPlayerDestroyer();
        NewModel C_Destroyer = nModel.getComputerDestroyer();
        NewModel P_Sub = nModel.getPlayerSub();
        NewModel C_Sub = nModel.getComputerSub();




        // grab the ship model


        if(checkhits(hitpoint, P_Aircraft.getStart(), P_Aircraft.getEnd())){
                nModel.setHit();
        }else if(checkhits(hitpoint, P_Battleship.getStart(), P_Battleship.getEnd())){

        }

    }



    //check if there is any ship
    public boolean checkhits(Point thisshot, Point starts, Point ends){

        if (thisshot.x == starts.x ){
            if (thisshot.y <= ends.y && thisshot.y >= starts.y){
                return true;
            }
        }else if(thisshot.y == starts.y){
            if (thisshot.x <= ends.x && thisshot.x >= starts.x) {
                return true;
            }
        }
            return false;
    }



    //update the game state







}
