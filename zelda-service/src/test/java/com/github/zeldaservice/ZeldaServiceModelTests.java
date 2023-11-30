package com.github.zeldaservice;

import com.github.zeldaservice.model.ZeldaGame;
import com.github.zeldaservice.model.ZeldaGameResponse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ZeldaGameTests {

    @Test
    void testZeldaGame() {
        ZeldaGame game = new ZeldaGame();
        game.setName("The Legend of Zelda");
        game.setDescription("Action-adventure game");
        game.setDeveloper("Nintendo");
        game.setPublisher("Nintendo");
        game.setReleased_date("1986-02-21");
        game.setId("1");

        assertEquals("The Legend of Zelda", game.getName());
        assertEquals("Action-adventure game", game.getDescription());
        assertEquals("Nintendo", game.getDeveloper());
        assertEquals("Nintendo", game.getPublisher());
        assertEquals("1986-02-21", game.getReleased_date());
        assertEquals("1", game.getId());
    }

    @Test
    void testZeldaGameResponse() {
        ZeldaGame game = new ZeldaGame();
        game.setName("The Legend of Zelda");
        game.setDescription("Action-adventure game");
        game.setDeveloper("Nintendo");
        game.setPublisher("Nintendo");
        game.setReleased_date("1986-02-21");
        game.setId("1");

        List<ZeldaGame> gameList = Arrays.asList(game);

        ZeldaGameResponse response = new ZeldaGameResponse();
        response.setSuccess(true);
        response.setCount(1);
        response.setData(gameList);

        assertEquals(true, response.isSuccess());
        assertEquals(1, response.getCount());
        assertNotNull(response.getData());
        assertEquals(1, response.getData().size());
        assertEquals("The Legend of Zelda", response.getData().get(0).getName());
    }
}
