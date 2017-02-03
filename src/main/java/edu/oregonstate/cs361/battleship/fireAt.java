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
        Point Aircraftstart =new Point(nModel.getPlayerAircraftStart());

        // grab the ship model


            if(checkhits(hitpoint, startpoint, endpoint)){
                nModel.setHit();
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
