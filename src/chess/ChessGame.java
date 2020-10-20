package chess;

public class ChessGame {

	boolean whiteTurn = true;
	boolean gameFinished = false;

	public ChessGame() {
		
		Board board = new Board();
		board.printBoard();
		
		while (!gameFinished) {
			if (whiteTurn) {
				System.out.println("White's move: ");
			}
			gameFinished = true;
	}

}

}