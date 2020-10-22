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
		Scanner scanner = new Scanner(System.in);
		String x = "abcdefgh";

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

				int fromX = x.indexOf(input.charAt(0));
				int fromY = input.charAt(1) - '0' - 1;

				int toX = x.indexOf(input.charAt(3));
				int toY = input.charAt(4) - '0' - 1;

				Spot spotFrom = board.getBox(fromY, fromX);
				Spot spotTo = board.getBox(toY, toX);

				System.out.println("Trying moving from: " + spotFrom.toString());
				System.out.println("Trying moving to: " + spotTo.toString());

				move(spotFrom, spotTo);
			}

		}

		if (whiteTurn && gameFinished) {
			System.out.println("Black wins");
		}

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
		//System.out.println("Tring to move");
		if (from.getPiece().canMove(board, from, to)) {
			to.setPiece(from.getPiece());
			from.setPiece(null);
			board.printBoard();
		} else {
			System.out.println("Illegal move, try again");
		}
		
		this.whiteTurn = !this.whiteTurn;
	}

	public void movedAndKill(Spot from, Spot to) {
		//System.out.println("Tring to move and kill");
		this.whiteTurn = !this.whiteTurn;
	}

}
