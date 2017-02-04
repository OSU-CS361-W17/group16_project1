package edu.oregonstate.cs361.battleship;


import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by jiayu on 2017-02-01.
 */

class fireAtTest {
    @Test
    public static boolean testcheckshots(Point thisshot, Point starts, Point ends){
        boolean notworking = false;
        boolean val;
        thisshot = new Point(1,2);
        starts = new Point(2,3);
        ends = new Point(2,5);
        val = fireAt.checkhits(thisshot, starts, ends);
        assertEquals(notworking, val);
        return val;
    }



}