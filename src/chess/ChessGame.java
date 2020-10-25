package chess;

import java.util.Scanner;

public class ChessGame {
	Board board;
	boolean whiteTurn;
	boolean gameFinished;
	boolean draw;

	public ChessGame() {
		whiteTurn = true;
		gameFinished = false;
		board = new Board();
		draw = false;
	}
	
	public ChessGame clone() {
		ChessGame clone = new ChessGame();
		clone.board = this.board.clone();
		clone.whiteTurn = this.whiteTurn;
		clone.gameFinished = this.gameFinished;
		clone.draw = this.draw;
		
		return clone;
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);
		String x = "abcdefgh";
		board.printBoard();
		System.out.println();
		while (!gameFinished) {
			if (board.isCheckmate(whiteTurn)) {
				System.out.println("Checkmate");
				gameFinished = true;
			}
			if (board.isInCheck(whiteTurn))
				System.out.println("Check");

			if (whiteTurn) {
				System.out.print("White's move: ");
			} else {
				System.out.print("Black's move: ");
			}

			String input = scanner.nextLine();

			if (input.equals("draw")) {
				gameFinished = true;
			} else {

				int fromCol = x.indexOf(input.charAt(0));
				int fromRow = input.charAt(1) - '0' - 1;

				int toCol = x.indexOf(input.charAt(3));
				int toRow = input.charAt(4) - '0' - 1;

				Spot spotFrom = board.getSpot(fromRow, fromCol);
				Spot spotTo = board.getSpot(toRow, toCol);

				System.out.println("Trying moving from: " + spotFrom.toString());
				System.out.println("Trying moving to: " + spotTo.toString());

				board.move(spotFrom, spotTo, true);

			}

		}

		if (whiteTurn) {
			System.out.println("Black wins");
		} else
			System.out.println("White wins");

		scanner.close();
	}

	

	

	



}
