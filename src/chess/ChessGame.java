package chess;

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
		while (!gameFinished) {
			if (whiteTurn) {
				System.out.println("White's move: ");
			}
			gameFinished = true;
		}
	}

}