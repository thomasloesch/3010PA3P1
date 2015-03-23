// FILE: Connect4Game.java
// NAME: Thomas Loesch
// DATE: 03/22/15

import java.util.ArrayList;

public class Connect4Game {
	private int gameState;
	private Column[] gameArray;
	
	public static final int CHECKER_PLAYER_1 = 1;
	public static final int CHECKER_PLAYER_2 = 2;
	
	public static final int ERROR = 0;
	public static final int PLAYER_1_TURN = 1;
	public static final int PLAYER_2_TURN = 2;
	public static final int PLAYER_1_WIN = 3;
	public static final int PLAYER_2_WIN = 4;
	public static final int TIE = 5;
	
	public Connect4Game() { 
		gameState = 1; 
		gameArray = new Column[8];
		for(int i = 0; i < gameArray.length; i++) gameArray[i] = new Column();
	}
	
	public boolean makeMove(int col) { 
		if(gameState != PLAYER_1_TURN || gameState != PLAYER_2_TURN) throw new IllegalStateException("You can't make a move right now");
		boolean retval = gameArray[col].add(gameState); 
		
		if(retval){
			if(gameState == 1)
				gameState = 2;
			else
				gameState = 1;
		}
		
		return retval;
	}
	
	public int getGameState() { return gameState; }
	
	public void reset() { for(int i = 0; i < gameArray.length; i++) gameArray[i].reset(); gameState = 1;}
	
	public int getValueInLoc(int row, int col) { return gameArray[col].getLoc(row); }
	
	public ArrayList<Integer> getAllPossibleMoves() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i = 0; i < gameArray.length; i++)
			temp.add(gameArray[i].getTop());
		
		return temp;
	}
	
	private class Column {
		private int top;
		private int[] contents;
		
		public Column() { contents = new int[6]; top = 0; }
		
		public boolean add(int x) { 
			if(isFull() == true) return false;
			contents[top++] = x; 
			return true;
		}
		
		public int getTop() { if(top == 7) return -1; return top; }
		
		public int getLoc(int x) { return contents[x]; }
		
		public void reset() { for(int i = 0; i < contents.length; i++) contents[i] = 0; top = 0; }
		
		public boolean isFull() { if(top == 7) return true; else return false; }
	}
}
