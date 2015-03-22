// FILE: Connect4Game.java
// NAME: Thomas Loesch
// DATE: 03/22/15

import java.util.ArrayList;

public class Connect4Game {
	private int gameState;
	private Column[] gameArray;
	// TODO: add variable to hold the state of the game pieces
	// IDEA: do so by making an array of subclasses (Column)
	
	public void Connect4Game() { gameState = 1; }
	
	public boolean makeMove() { return false; }
	
	public int getGameState() { return gameState; }
	
	public void reset() { }
	
	public int getValueInLoc(int row, int col) { return 0; }
	
	public ArrayList<Integer> getAllPossibleMoves() {
		return null; 
	}
	
	private class Column {
		
		public Column() { }
	}
}
