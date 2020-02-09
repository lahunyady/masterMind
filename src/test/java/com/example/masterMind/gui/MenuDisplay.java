package com.example.masterMind.gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class MenuDisplay {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream backup = System.in;

    MainMenu menu;

    @Before
    public void setup() {
        menu = new MainMenu();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void teardown() {
        System.setOut(originalOut);
        System.setIn(backup);
    }

    @Test
    public void test_showWelcomePrintsText() {
        menu.showWelcome();

        assertNotEquals("\r\n", outContent.toString());
    }

    @Test
    public void test_askForSecret_AAAA() {
        String TEST_STRING = "AAAA";
        mockStdIn(TEST_STRING);

        String line = menu.readLine();

        assertEquals(TEST_STRING, line);
    }

    @Test
    public void test_askForSecret_BBBB() {
        String TEST_STRING = "BBBB";
        mockStdIn(TEST_STRING);

        String line = menu.readLine();
        assertEquals(TEST_STRING, line);
    }

    @Test
    public void test_congratulationsPrintsText() {
        menu.showCongratulations();
        assertNotEquals("\r\n", outContent.toString());
    }

    private void mockStdIn(String mockInput) {
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));
    }
}
