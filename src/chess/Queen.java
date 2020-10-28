package chess;

/**
 * Queen class
 * 
 * @author Mustafa Sadiq (ms3035)
 * @author Robert Mannifield (rmm288)
 *
 */
public class Queen extends Piece {

	/**
	 * Constructor for Queen (black or white)
	 * @param white isWhite?
	 */
	public Queen(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public boolean canMove(Board board, Spot from, Spot to) {
		// TODO Auto-generated method stub
		return new Rook(from.getPiece().isWhite()).canMove(board, from, to)
				|| new Bishop(from.getPiece().isWhite()).canMove(board, from, to);
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		if (this.isWhite())
			return "wQ";
		else
			return "bQ";
	}

}
