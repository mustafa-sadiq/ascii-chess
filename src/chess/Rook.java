package chess;

/**
 * 
 * Rook class
 * 
 * @author Mustafa Sadiq (ms3035)
 * @author Robert Mannifield (rmm288)
 *
 */
public class Rook extends Piece {

	/**
	 * Constructor for Rook (black or white)
	 * @param white
	 */
	public Rook(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public boolean canMove(Board board, Spot from, Spot to) {
		// TODO Auto-generated method stub
		if (from.getRow() != to.getRow() && from.getCol() != to.getCol()) {
			return false;
		} else if (from.getRow() == to.getRow()) {
			int direction;
			if (from.getCol() < to.getCol())
				direction = 1;
			else
				direction = -1;

			for (int i = from.getCol() + direction; i != to.getCol(); i += direction) {
				if (board.getSpot(from.getRow(), i).getPiece() != null)

					return false;
			}
		} else if (from.getCol() == to.getCol()) {
			int direction;
			if (from.getRow() < to.getRow())
				direction = 1;
			else
				direction = -1;
			for (int i = from.getRow() + direction; i != to.getRow(); i += direction) {
				if (board.getSpot(i, from.getCol()).getPiece() != null)

					return false;
			}
		}
		return true;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		if (this.isWhite())
			return "wR";
		else
			return "bR";
	}
}
