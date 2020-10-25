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
			if (isInCheck(whiteTurn))
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

				move(spotFrom, spotTo, true);

				if (isCheckmate(whiteTurn)) {
					System.out.println("Checkmate");
					gameFinished = true;
				}
			}

		}

		if (whiteTurn) {
			System.out.println("Black wins");
		} else
			System.out.println("White wins");

		scanner.close();
	}

	public boolean move(Spot from, Spot to, boolean makeMove) {
		if (from.getPiece() == null) {
			if (makeMove) {
				System.out.println("No piece to move! Try again");
			}
			return false;
		}

		else if (this.whiteTurn != from.getPiece().isWhite()) {
			if (makeMove) {
				System.out.println("Can't move opponent piece! Try again");
			}
			return false;
		}

		else if (to.getPiece() != null && from.getPiece().isWhite() == to.getPiece().isWhite()) {
			if (makeMove) {
				System.out.println("Can't move to own piece! Try again");
			}
			return false;
		}

		else if (from.getPiece().canMove(board, from, to) && makeMove) {
			makeMove(from, to);
			return true;
		}

		else if (from.getPiece().canMove(board, from, to) && !makeMove) {
			return true;
		}

		else if (makeMove) {
			System.out.println("Illegal move, try again");
			return false;
		}

		return false;

	}

	public void makeMove(Spot from, Spot to) {

		System.out.println("Trying to move");
		to.setPiece(from.getPiece());
		from.setPiece(null);
		System.out.println();
		board.printBoard();
		System.out.println();

		if (isInCheck(whiteTurn)) {
			this.whiteTurn = !this.whiteTurn;
			this.gameFinished = true;
		}

		this.whiteTurn = !this.whiteTurn;

	}

	public Spot getKingSpot(boolean isWhite) {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (board.getSpot(row, col).getPiece() instanceof King
						&& board.getSpot(row, col).getPiece().isWhite() == isWhite) {
					return board.getSpot(row, col);
				}
			}
		}
		return new Spot(0, 0, null);
	}

	public boolean isInCheck(boolean isWhite) {
		Spot kingPos = getKingSpot(isWhite);
		System.out.println(kingPos);

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (board.getSpot(row, col).getPiece() != null
						&& board.getSpot(row, col).getPiece().isWhite() == !isWhite) {
					if (board.getSpot(row, col).getPiece().canMove(board, board.getSpot(row, col), kingPos)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean isCheckmate(Boolean isWhite) {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				// Spot (x,y)
				for (int z = 0; z < 8; z++) {
					for (int w = 0; w < 8; w++) {
						// Spot (z, w)
						if (board.getSpot(x, y).getPiece() != null) {
							if (board.getSpot(x, y).getPiece().isWhite() == isWhite) {
								if (move(board.getSpot(x, y), board.getSpot(z, w), false)) {
									return false;
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

}
