package chess;

import java.util.Scanner;

public class ChessGame {
	Board board;
	boolean whiteTurn;
	boolean gameFinished;

	public ChessGame() {
		whiteTurn = true;
		gameFinished = false;
		board = new Board();
		board.printBoard();
	}

	public void play() {
		Scanner input = new Scanner(System.in);
		
		while (!gameFinished) {
			if (whiteTurn) {
				System.out.print("White's move: ");
			} else {
				System.out.print("Black's move: ");
			}
			
			String moveFrom = input.next();
			System.out.println(moveFrom);
			
			String moveTo = input.next();
			System.out.println(moveTo);
			
			
			gameFinished = true;
		}
		
		input.close();
	}
	
	public void move() {
		
	}

}