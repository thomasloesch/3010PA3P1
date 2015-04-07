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
		int move;
		
		do {
			displayGame(game);
			do {
				move = getInput(scan);
				game.makeMove(move);
				displayGame(game);
			} while(game.getGameState() == Connect4Game.PLAYER_1_TURN || game.getGameState() == Connect4Game.PLAYER_2_TURN);
			
			System.out.print("Would you like to play another game? (yes/no) ");
			input = scan.next();
			System.out.println();
			
			if(input.equals("yes"))
				game.reset();
			
		} while(input.equals("yes"));
		
		scan.close();
		
		System.exit(0);
	}
	
	public static void displayGame(Connect4Game game) {
		System.out.print("====");
		if(game.getGameState() == Connect4Game.PLAYER_1_TURN || 
		   game.getGameState() == Connect4Game.PLAYER_2_TURN)		System.out.print("TURN " + game.getTurn());
		else if(game.getGameState() == Connect4Game.PLAYER_1_WIN)	System.out.print("O WINS");
		else if(game.getGameState() == Connect4Game.PLAYER_2_WIN)	System.out.print("X WINS");
		else if(game.getGameState() == Connect4Game.TIE)			System.out.print("TIE");
		else														System.out.print("ERROR");
		System.out.println("====");
		
		for(int i = 5; i >= 0; i--)
			displayRow(i, game);
		System.out.println("--------");
		if	(game.getGameState() == Connect4Game.PLAYER_1_TURN) System.out.print("O");
		else													System.out.print("X");
		System.out.println("'s turn.");
	}

	public static void displayRow(int row, Connect4Game game) {
		for(int i = 0; i < 8; i++) {
			if		(game.getValueInLoc(i, row) == Connect4Game.CHECKER_PLAYER_1) 	System.out.print("O");
			else if (game.getValueInLoc(i, row) == Connect4Game.CHECKER_PLAYER_2) 	System.out.print("X");
			else																	System.out.print(" ");
		}
		System.out.println();
	}

	public static int getInput(Scanner scan) {
		int retval;
		
		System.out.print("Which column would you like to place a checker in? ");
		retval = scan.nextInt();
		
		return retval;
	}
}

