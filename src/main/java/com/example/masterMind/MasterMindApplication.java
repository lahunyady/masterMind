package com.example.masterMind;

import com.example.masterMind.gui.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MasterMindApplication implements CommandLineRunner {

	@Autowired
	MainMenu menu;

	@Autowired
	GameEngine engine;

	public static void main(String[] args) {
		SpringApplication.run(MasterMindApplication.class, args);
	}

	@Override
	public void run(String... args) {
		menu.showWelcome();
		menu.showGuess(engine.guess());

		while (!engine.isWin(menu.readLine())) {
			menu.showGuess(engine.guess());
		}

		menu.showCongratulations();
	}
}
