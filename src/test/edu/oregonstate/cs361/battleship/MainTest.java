package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spark.Spark;
import spark.utils.IOUtils;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static spark.Spark.awaitInitialization;


/**
 * Created by michaelhilton on 1/26/17.
 */
class MainTest {

    @BeforeAll
    public static void beforeClass() {
        Main.main(null);
        awaitInitialization();
    }

    @AfterAll
    public static void afterClass() {
        Spark.stop();
    }

    @Test
    public void testGetModel() {
        TestResponse res = request("GET", "/model");
        assertEquals(200, res.status);

        String info = res.body;
        Gson gson = new Gson();
        BattleshipModel test = gson.fromJson(info, BattleshipModel.class);

        assertEquals(info, res.body);

    }

    @Test
    public void testPlaceShip1() {
        TestResponse res = request("POST", "/placeShip/aircraftCarrier/1/1/horizontal");
        assertEquals(200, res.status);
        assertEquals("SHIP",res.body);
    }
    //Test invalid horizontal placement
    @Test
    public void testPlaceShip2() {
        TestResponse res = request("POST", "/placeShip/destroyer/11/10/horizontal");
        assertEquals(200, res.status);
        assertEquals("Invalid",res.body);
    }
    //Test invalid vertical placement
    @Test
    public void testPlaceShip3() {
        TestResponse res = request("POST", "/placeShip/destroyer/9/11/vertical");
        assertEquals(200, res.status);
        assertEquals("Invalid",res.body);
    }
    @Test
    public void testPlaceShip4() {
        TestResponse res = request("POST", "/placeShip/submarine/5/4/vertical");
        assertEquals(200, res.status);
        assertEquals("SHIP",res.body);
    }
    @Test
    public void testPlaceShip5() {
        TestResponse res = request("POST", "/placeShip/cruiser/7/7/vertical");
        assertEquals(200, res.status);
        assertEquals("SHIP",res.body);
    }
    @Test
    public void testPlaceShip6() {
        TestResponse res = request("POST", "/placeShip/battleship/5/4/vertical");
        assertEquals(200, res.status);
        assertEquals("SHIP",res.body);
    }
    @Test
    public void testgetShipLength1() {
        String ship = "battleship";
        int result = Main.getShipLength(ship);
        assertEquals(4, result);
    }
    @Test
    public void testgetShipLength2() {
        String ship = "cruiser";
        int result = Main.getShipLength(ship);
        assertEquals(3, result);
    }
    @Test
    public void testgetShipLength3() {
        String ship = "aircraftCarrier";
        int result = Main.getShipLength(ship);
        assertEquals(5, result);
    }
    @Test
    public void testgetShipLength4() {
        String ship = "submarine";
        int result = Main.getShipLength(ship);
        assertEquals(3, result);
    }
    @Test
    public void testgetShipLength5() {
        String ship = "destroyer";
        int result = Main.getShipLength(ship);
        assertEquals(2, result);
    }

    @Test
    public void testgetIdNum1() {
        String ship = "submarine";
        int result = Main.getIdNum(ship);
        assertEquals(5, result);
    }
    @Test
    public void testgetIdNum2() {
        String ship = "destroyer";
        int result = Main.getIdNum(ship);
        assertEquals(4, result);
    }
    @Test
    public void testgetIdNum3() {
        String ship = "cruiser";
        int result = Main.getIdNum(ship);
        assertEquals(3, result);
    }
    @Test
    public void testgetIdNum4() {
        String ship = "battleship";
        int result = Main.getIdNum(ship);
        assertEquals(2, result);
    }
    @Test
    public void testgetIdNum5() {
        String ship = "aircraftCarrier";
        int result = Main.getIdNum(ship);
        assertEquals(1, result);
    }
    @Test
    public void testcheckfirepoint() {
        TestResponse res = request("POST", "/fire/7/7");
        int firerow = 7, firecol = 7;
        Point firepoint = new Point(firerow,firecol);
        Point x = new Point(7,7);
        assertEquals(200, res.status);
        assertEquals(x, firepoint);
    }
    @Test
    public void fireat1(){
        TestResponse res = request("POST", "/fire/13/7");
        assertEquals(200, res.status);
        assertEquals("hit",res.body);
    }
    @Test
    public void fireat2(){
        TestResponse res = request("POST", "/fire/9/7");
        assertEquals(200, res.status);
        assertEquals("hit",res.body);
    }

    @Test
    public void fireat3(){
        TestResponse res = request("POST", "/fire/5/7");
        assertEquals(200, res.status);
        assertEquals("hit",res.body);
    }

    @Test
    public void fireat4(){
        TestResponse res = request("POST", "/fire/4/7");
        assertEquals(200, res.status);
        assertEquals("hit",res.body);
    }

    @Test
    public void fireat5(){
        TestResponse res = request("POST", "/fire/1/0");
        assertEquals(200, res.status);
        assertEquals("hit",res.body);
    }

    @Test
    public void fireat6(){
        TestResponse res = request("POST", "/fire/19/7");
        assertEquals(200, res.status);
        assertEquals("hit",res.body);
    }
    @Test
    public void fireat7(){
        TestResponse res = request("POST", "/fire/3/4");
        assertEquals(200, res.status);
        assertEquals("hit",res.body);
    }
    @Test
    public void fireat8(){
        TestResponse res = request("POST", "/fire/3/5");
        assertEquals(200, res.status);
        assertEquals("hit",res.body);
    }
    @Test
    public void fireat9(){
        TestResponse res = request("POST", "/fire/9/5");
        assertEquals(200, res.status);
        assertEquals("hit",res.body);
    }
    @Test
    public void fireat10(){
        TestResponse res = request("POST", "/fire/3/10");
        assertEquals(200, res.status);
        assertEquals("hit",res.body);
    }


    @Test
    public void testcheckshots1(){
        boolean notworking = false;
        boolean val = false;
            Point thisshot = new Point(1,2);
            Point starts = new Point(2,3);
            Point ends = new Point(2,5);
            val = Main.checkhits(thisshot, starts, ends);
        assertEquals(notworking, val);
    }
    @Test
    public void testcheckshots2(){
        boolean notworking = false;
        boolean val = false;
        Point thisshot = new Point(13,2);
        Point starts = new Point(2,3);
        Point ends = new Point(2,5);
        val = Main.checkhits(thisshot, starts, ends);
        assertEquals(notworking, val);
    }

    private TestResponse request(String method, String path) {
        try {
            URL url = new URL("http://localhost:4567" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            return new TestResponse(connection.getResponseCode(), body);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    private static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }

        public Map<String,String> json() {
            return new Gson().fromJson(body, HashMap.class);
        }
    }


}