package com.example.masterMind;

import com.example.masterMind.gui.MainMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class MasterMindApplicationTests {

    @Mock
    MainMenu menu;

    @Mock
    GameEngine engine;

    @Spy
    @InjectMocks
    MasterMindApplication app;

    @Test
    public void test_displayWelcome() {
        doReturn(true).when(engine).isWin(anyString());
        doReturn("").when(menu).readLine();

        app.run();

        verify(menu, times(1)).showWelcome();
    }

    @Test
    public void test_displayGuess() {
        when(engine.isWin(anyString()))
                .thenReturn(false)
                .thenReturn(true);
        doReturn("").when(menu).readLine();
        doReturn("").when(engine).guess();

        app.run();

        verify(menu, times(2)).showGuess(anyString());
    }

    @Test
    public void test_displayCongratulations() {
        doReturn(true).when(engine).isWin(anyString());
        doReturn("").when(menu).readLine();

        app.run();

        verify(menu, times(1)).showCongratulations();
    }

}
