package com.example.masterMind;

import com.example.masterMind.gui.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
class MasterMindApplicationTests {

    @Mock
    MainMenu menu;

    @Spy
    GameEngine engine;

    @InjectMocks
    MasterMindApplication app;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_showWelcome() throws Exception {
        app.run();

        verify(menu, times(1)).showWelcome();
    }

    @Test
    public void test_readInput() throws Exception {
        mockInput("AAAA");

        app.run();

        verify(menu, times(2)).readLine();
    }

    @Test
    public void test_validateGuess() throws Exception {
        mockInput("AAAA");

        app.run();

        verify(engine, times(1)).isGuessed("AAAA");
    }

    @Test
    public void test_firstGuessIsBad() throws Exception {
        nThGuessIsGood(2);
        doReturn(false).when(engine).isGuessed("AAAB");

        app.run();

        verify(engine, times(2)).isGuessed(anyString());
        verify(menu, times(1)).showGuess(anyString());
    }

    @Test
    public void test_CongratulationsMessage() {
        mockInput("AAAA");
        app.run();
        verify(menu, times(1)).showCongratulations();
    }

    private void nThGuessIsGood(int n) {

        when(menu.readLine())
                .thenReturn("AAAA").then(new DynamicAnswer(n));
    }

    private void mockInput(String secret) {
        doReturn(secret).when(menu).readLine();
    }

    static class DynamicAnswer implements Answer<String> {

        private final int count;
        private int actual = 1;

        public DynamicAnswer(int count) {
            this.count = count;
        }

        @Override
        public String answer(InvocationOnMock invocationOnMock) {
            if (count != actual++) {
                return "AAAB";
            }
            return "AAAA";
        }
    }
}
