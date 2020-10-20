package chess;

public class ChessGame {

	boolean whiteTurn;
	boolean gameFinished;

	public ChessGame() {
		whiteTurn = true;
		gameFinished = false;
		Board board = new Board();
		board.printBoard();
		play();
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