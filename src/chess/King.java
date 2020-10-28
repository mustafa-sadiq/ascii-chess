package chess;

/**
 * 
 * King class
 * 
 * @author Mustafa Sadiq (ms3035)
 * @author Robert Mannifield (rmm288)
 *
 */
public class King extends Piece {

	/**
	 * is the current move a castling move
	 */
	private boolean castled;

	/**
	 * getter for castled
	 * @return castled
	 */
	public boolean getCastled() {
		return castled;
	}

	/**
	 * setter for castled
	 * @param value castled
	 */
	public void setCastled(boolean value) {
		castled = value;
	}

	/**
	 * Constructor for King (black or white) 
	 * @param white isWhite
	 */
	public King(boolean white) {
		super(white);
		castled = false;
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	@Override
	public boolean canMove(Board board, Spot from, Spot to) {
		// TODO Auto-generated method stub
		if (Math.abs(to.getRow() - from.getRow()) > 1 || Math.abs(to.getCol() - from.getCol()) > 1) {
			if (from.getPiece().hasMoved()) {
				return false;
			}
			if (to.getCol() - from.getCol() == 2 && from.getRow() == to.getRow()) {

				if (board.getSpot(to.getRow(), from.getCol() + 1).getPiece() != null
						|| board.getSpot(to.getRow(), from.getCol() + 2).getPiece() != null) {
					if (board.getSpot(to.getRow(), 7).getPiece() == null) {
						castled = false;
						return false;
					}
					if (!(board.getSpot(to.getRow(), 7).getPiece() instanceof Rook)) {
						castled = false;
						return false;
					}
					if (board.getSpot(to.getRow(), 7).getPiece() instanceof Rook && board.getSpot(to.getRow(), 7).getPiece().hasMoved()) {
						castled = false;
						return false;
					}
					
				}

			}

			else if (from.getCol() - to.getCol() == 2 && from.getRow() == to.getRow()) {
				if (board.getSpot(to.getRow(), from.getCol() - 1).getPiece() != null
						|| board.getSpot(to.getRow(), from.getCol() - 2).getPiece() != null
						|| board.getSpot(to.getRow(), from.getCol() - 3).getPiece() != null) {
					if (board.getSpot(to.getRow(), 0).getPiece() == null) {
						castled = false;
						return false;
					}
					if (!(board.getSpot(to.getRow(), 0).getPiece() instanceof Rook)) {
						castled = false;
						return false;
					}
					if (board.getSpot(to.getRow(), 0).getPiece() instanceof Rook && board.getSpot(to.getRow(), 0).getPiece().hasMoved()) {
						castled = false;
						return false;
					}
					
				}

			}

			else {
				castled = false;
				return false;
			}

			castled = true;

		}

		return true;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		if (this.isWhite())
			return "wK";
		else
			return "bK";
	}
}
