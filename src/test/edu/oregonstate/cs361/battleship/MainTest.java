package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spark.Spark;
import spark.utils.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static spark.Spark.awaitInitialization;

import static spark.Spark.init;


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