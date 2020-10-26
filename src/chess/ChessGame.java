package chess;

import java.util.Scanner;

public class ChessGame {
	private Board board;
	private boolean whiteTurn;
	private boolean gameFinished;
	private boolean gamedraw;

	public boolean getWhiteTurn() {
		return this.whiteTurn;
	}

	public ChessGame() {
		whiteTurn = true;
		gameFinished = false;
		board = new Board();
		gamedraw = false;
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);

		board.printBoard(false);
		System.out.println();

		while (!gameFinished) {
			if (board.isInCheck(whiteTurn))
				System.out.println("Check");

			System.out.println(board.isMovePossible(whiteTurn));

			if (!board.isMovePossible(whiteTurn)) {
				System.out.println("Checkmate2");
				gameFinished = true;
				end();
			}

			if (!gameFinished) {
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

					System.out.println("Trying moving from: " + spotFrom.toString());
					System.out.println("Trying moving to: " + spotTo.toString());

					try {
						board.tryMove(spotFrom, spotTo, whiteTurn, true);
						board.printBoard(true);
						if (board.isInCheck(whiteTurn)) {
							System.out.println("Checkmate");
							this.gameFinished = true;
							end();
						}

						whiteTurn = !whiteTurn;
					} catch (IllegalMoveException e) {

					}

				}
			}

		}

		scanner.close();
	}

	public void end() {
		if (gamedraw)
			System.out.println("Draw");

		else if (whiteTurn) {
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
