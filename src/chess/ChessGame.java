package chess;

import java.util.Scanner;

public class ChessGame {
	private Board board;
	private boolean whiteTurn;
	private boolean gameFinished;

	public boolean getWhiteTurn() {
		return this.whiteTurn;
	}

	public ChessGame() {
		whiteTurn = true;
		gameFinished = false;
		board = new Board();
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);

		board.printBoard(false);
		System.out.println();

		while (!gameFinished) {

			try {
				if (!board.isMovePossible(whiteTurn)) {				
					System.out.println("Checkmate");
					gameFinished = true;
					end();			
			}
			} catch (NullPointerException e) {
				System.out.println("Draw");
				gameFinished = true;
			}
			
			
			// System.out.println(board.isMovePossible(whiteTurn));

			if (!gameFinished) {

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
					end();
				}

				else if (input.equals("resign")) {
					gameFinished = true;
					end();
				}

				else {
					Spot[] spots = readSpots(input);
					Spot spotFrom = spots[0];
					Spot spotTo = spots[1];

					// System.out.println("Trying moving from: " + spotFrom.toString());
					// System.out.println("Trying moving to: " + spotTo.toString());

					try {

						board.tryMove(spotFrom, spotTo, whiteTurn, true);

						if (spotTo.getPiece() instanceof Pawn && whiteTurn && spotTo.getRow() == 7) {
							if (input.length() == 5) {
								System.out.println("Promoting to queen");
								spotTo.setPiece(new Queen(whiteTurn));
							} else if (input.length() == 7) {
								if (input.charAt(6) == 'B') spotTo.setPiece(new Bishop(whiteTurn));
								if (input.charAt(6) == 'N') spotTo.setPiece(new Knight(whiteTurn));
								if (input.charAt(6) == 'R') spotTo.setPiece(new Rook(whiteTurn));
								if (input.charAt(6) == 'Q') spotTo.setPiece(new Queen(whiteTurn));								
							}
						}

						if (spotTo.getPiece() instanceof Pawn && !whiteTurn && spotTo.getRow() == 0) {
							if (input.length() == 5) {
								System.out.println("Promoting to queen");
								spotTo.setPiece(new Queen(whiteTurn));
							} else if (input.length() == 7) {
								if (input.charAt(6) == 'B') spotTo.setPiece(new Bishop(whiteTurn));
								if (input.charAt(6) == 'N') spotTo.setPiece(new Knight(whiteTurn));
								if (input.charAt(6) == 'R') spotTo.setPiece(new Rook(whiteTurn));
								if (input.charAt(6) == 'Q') spotTo.setPiece(new Queen(whiteTurn));									
							}
						}

						board.printBoard(true);

						if (board.isInCheck(whiteTurn)) {
							System.out.println("Checkmate");
							this.gameFinished = true;
							end();
						}

						 whiteTurn = !whiteTurn;
					} catch (IllegalMoveException e) {
						System.out.println("Illegal move, try again");
					}

				}
			}

		}

		scanner.close();
	}

	public void end() {
		if (whiteTurn) {
			System.out.println("Black wins");
		} else
			System.out.println("White wins");
	}

	public Spot[] readSpots(String input) {
		String x = "abcdefgh";

		int fromCol = x.indexOf(input.charAt(0));
		int fromRow = input.charAt(1) - '0' - 1;

		int toCol = x.indexOf(input.charAt(3));
		int toRow = input.charAt(4) - '0' - 1;

		Spot spotFrom = board.getSpot(fromRow, fromCol);
		Spot spotTo = board.getSpot(toRow, toCol);

		Spot[] retValue = { spotFrom, spotTo };
		return retValue;

	}

}
