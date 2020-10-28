package chess;

/**
 * Knight class 
 * 
 * @author Mustafa Sadiq (ms3035)
 * @author Robert Mannifield (rmm288)
 *
 */
public class Knight extends Piece {

	/**
	 * Constructor for Knight (black or white)
	 * @param white
	 */
	public Knight(boolean white) {
		super(white);
	}

	/**
	 *
	 */
	@Override
	public boolean canMove(Board board, Spot from, Spot to) {

		int row = Math.abs(from.getRow() - to.getRow());
		int col = Math.abs(from.getCol() - to.getCol());

		return row * col == 2;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		if (this.isWhite())
			return "wN";
		else
			return "bN";
	}
}
