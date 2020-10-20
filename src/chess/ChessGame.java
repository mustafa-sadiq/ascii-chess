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

	public void play() throws Exception {
		Scanner scanner = new Scanner(System.in);
		String x = "abcdefgh";
		
		while (!gameFinished) {
			if (whiteTurn) {
				System.out.print("White's move: ");
			} else {
				System.out.print("Black's move: ");
			}
			
			String input = scanner.nextLine();
			System.out.println(input + "\n");
			int fromX = x.indexOf(input.charAt(0));
			int fromY = input.charAt(1)-48;
			
			int toX = x.indexOf(input.charAt(3));
			int toY = input.charAt(4)-48;
			
			Spot spotFrom = board.getBox(fromX, fromY);
			Spot spotTo = board.getBox(toX, toY);
			
			move(spotFrom, spotTo);
			
			
		}
		
		scanner.close();
	}
	
	public void move(Spot from, Spot to) {
		gameFinished = true;
	}
	
	public void getSpotFrom(String value) {
		
	}

}