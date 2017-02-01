package edu.oregonstate.cs361.battleship;


/**
 * Created by Jiayu on 2017-01-30.
 */
public class fireAt {
    public static void main(String[] args){
        int x, y;
        x = 0;
        y = 0;
        if (x < 1 || x > 10 || y < 1 || y > 10) {
            System.out.println("invalid point");
        }else{
            System.out.println("valid input");
        }

    }
}
