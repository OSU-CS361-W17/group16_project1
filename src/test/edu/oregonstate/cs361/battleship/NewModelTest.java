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
 * Created by Noda Dragon on 2/3/2017.
 */
public class NewModelTest {

    @Test
    public void testStartPosition() {
        NewModel model = new NewModel();
        int x = 1;
        int y = 2;
        int shipId = 1;

        String result = model.setStartPosition(shipId, x, y);
        assertEquals("placed", result);

        shipId = 2;
        result = model.setStartPosition(shipId, x, y);
        assertEquals("placed", result);

        shipId = 3;
        result = model.setStartPosition(shipId, x, y);
        assertEquals("placed", result);

        shipId = 4;
        result = model.setStartPosition(shipId, x, y);
        assertEquals("placed", result);

        shipId = 5;
        result = model.setStartPosition(shipId, x, y);
        assertEquals("placed", result);

        shipId = 6;
        result = model.setStartPosition(shipId, x, y);
        assertEquals("placed", result);

        shipId = 7;
        result = model.setStartPosition(shipId, x, y);
        assertEquals("placed", result);

        shipId = 8;
        result = model.setStartPosition(shipId, x, y);
        assertEquals("placed", result);

        shipId = 9;
        result = model.setStartPosition(shipId, x, y);
        assertEquals("placed", result);

        shipId = 10;
        result = model.setStartPosition(shipId, x, y);
        assertEquals("placed", result);

        //Test invalid ship
        shipId = 11;
        result = model.setStartPosition(shipId, x, y);
        assertEquals("failed", result);
    }

    @Test
    public void testGetandSetPlayerHit() {
        NewModel model = new NewModel();

        model.setplayerHit();
        int result = model.getplayerHit();
        assertEquals(1, result);

        model.setplayerHit();
        result = model.getplayerHit();
        assertEquals(2, result);

        model.setplayerHit();
        result = model.getplayerHit();
        assertEquals(3, result);
    }

    @Test
    public void testGetandSetPlayerMiss() {
        NewModel model = new NewModel();

        model.setplayerMiss();
        int result = model.getplayerMiss();
        assertEquals(1, result);

        model.setplayerMiss();
        result = model.getplayerMiss();
        assertEquals(2, result);

        model.setplayerMiss();
        result = model.getplayerMiss();
        assertEquals(3, result);
    }

    @Test
    public void testGetandSetAIMiss() {
        NewModel model = new NewModel();

        model.setAIMiss();
        int result = model.getAIMiss();
        assertEquals(1, result);

        model.setAIMiss();
        result = model.getAIMiss();
        assertEquals(2, result);

        model.setAIMiss();
        result = model.getAIMiss();
        assertEquals(3, result);
    }

    @Test
    public void testGetandSetAIHit() {
        NewModel model = new NewModel();

        model.setAIHit();
        int result = model.getAIHit();
        assertEquals(1, result);

        model.setAIHit();
        result = model.getAIHit();
        assertEquals(2, result);

        model.setAIHit();
        result = model.getAIHit();
        assertEquals(3, result);
    }
}
