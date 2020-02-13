package com.example.masterMind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class GameEngineTest {
    @Spy
    GameEngine engine;

    @Test
    public void test_firstGuess() {
        assertEquals("AAAA", engine.guess());
    }

    @Test
    public void test_isWin_true() {
        assertTrue(engine.isWin("++++"));
    }

    @Test
    public void test_isWin_false() {
        assertFalse(engine.isWin("-+++"));
    }

    @Test
    public void test_secondGuess() {
        engine.isWin("---+");

        assertNotEquals("AAAA", engine.guess());
    }

    @Test
    public void test_hit() {

    }
}