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
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);
		String x = "abcdefgh";
		board.printBoard();
		System.out.println();
		while (!gameFinished) {
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

				Spot spotFrom = board.getBox(fromRow, fromCol);
				Spot spotTo = board.getBox(toRow, toCol);

				System.out.println("Trying moving from: " + spotFrom.toString());
				System.out.println("Trying moving to: " + spotTo.toString());

				move(spotFrom, spotTo);
			}

		}

		if (whiteTurn) {
			System.out.println("Black wins");
		} else System.out.println("White wins");

		scanner.close();
	}

	public void move(Spot from, Spot to) {
		if (from.getPiece() == null) {
			System.out.println("No piece to move! Try again");
		} else if (this.whiteTurn != from.getPiece().isWhite()) { 
			System.out.println("Can't move opponent piece! Try again");
		}
		else if (to.getPiece() != null && from.getPiece().isWhite() == from.getPiece().isWhite()) {
			System.out.println("Can't move to own piece! Try again");
		} else if (to.getPiece() != null) {
			movedAndKill(from, to);
		} else {
			moveToEmpty(from, to);
		}
		
		
	}

	public void moveToEmpty(Spot from, Spot to) {
		System.out.println("Trying to move");
		if (from.getPiece().canMove(board, from, to)) {
			to.setPiece(from.getPiece());
			from.setPiece(null);
			System.out.println();
			board.printBoard();
			System.out.println();
			//this.whiteTurn = !this.whiteTurn;
			
		} else {
			System.out.println("Illegal move, try again");
		}
		
		
	}

	public void movedAndKill(Spot from, Spot to) {
		System.out.println("Trying to move and kill");
		this.whiteTurn = !this.whiteTurn;
	}

}
