package chess;

public class Chess {

	public static void main(String[] args) {
		
		boolean whiteTurn = true;
		boolean gameFinished = false;
		
		System.out.println("Welcome to Chess32!");
		Board board = new Board();
		board.printBoard();
		
		while (!gameFinished) {
			if (whiteTurn) {
				System.out.println("White's move: ");
			}
			gameFinished = true;
		}
		
		
		System.out.println("\nGame Finished\nCredits: Mustafa and Robert");
		
		
	}

}
