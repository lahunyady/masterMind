package com.example.masterMind.gui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainMenu {

    @Value("${welcome_message}")
    public String WELCOME;

    @Value("${congratulations_message}")
    public String CONGRATULATIONS;


    public void showWelcome() {
        System.out.println(WELCOME);
    }

    public String readLine() {
        return new Scanner(System.in).nextLine();
    }

    public void showGuess(String nextGuess) {
        System.out.println(nextGuess);
    }

    public void showCongratulations() {
        System.out.println(CONGRATULATIONS);
    }
}
