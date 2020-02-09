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
		engine.setSecret(readInput());

		while (!isSecretGuessed()) {
			displayNextGuess();
		}

		menu.showCongratulations();
	}

	private boolean isSecretGuessed() {
		return engine.isGuessed(readInput());
	}

	private void displayNextGuess() {
		menu.showGuess(engine.nextGuess());
	}

	private String readInput() {
		return menu.readLine();
	}
}
