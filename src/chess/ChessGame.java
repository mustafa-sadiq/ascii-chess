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

				board.tryMove(spotFrom, spotTo, whiteTurn, true);

			}

		}

				
		if (whiteTurn && !gamedraw) {
			System.out.println("Black wins");
		} else if (!gamedraw)
			System.out.println("White wins");
		else System.out.println("Draw");

		scanner.close();
	}

}
