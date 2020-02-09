package com.example.masterMind;

import org.springframework.stereotype.Component;

@Component
public class GameEngine {

    public void setSecret(String secret) {

    }

    public boolean isGuessed(String guess) {
        return true;
    }

    public String nextGuess() {
        return "AAAA";
    }
}
