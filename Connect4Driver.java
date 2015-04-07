// FILE: Connect4Driver.java
// NAME: Thomas Loesch
// DATE: 03/22/15

import java.util.Scanner;

public class Connect4Driver {
	private static Connect4Game game;

	public static void main(String[] args) {
		game = new Connect4Game();
		Scanner scan = new Scanner(System.in);
		String input;
		
		do {
			input = getInput(scan);
			updateGame(input);
			displayGame();
		} while(game.getGameState() == Connect4Game.PLAYER_1_TURN || game.getGameState() == Connect4Game.PLAYER_2_TURN);
		
		// TODO: handle end of game and results display
		// IDEA: make another do-while loop so that game can be played multiple times
		
		scan.close();
		
		System.exit(0);
	}
	
	public static void updateGame(String input) {
		
		
	}
	
	public static void displayGame() {
		
		
	}

	public static String getInput(Scanner scan) {
		
		
		return "Input";
	}
}
