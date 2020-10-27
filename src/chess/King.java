package chess;

public class King extends Piece {

	private boolean castled;
	
	public King(boolean white) {
		super(white);
		castled = false;
		// TODO Auto-generated constructor stub
	}

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
					castled = false;
					return false;
				}

			} else if (from.getCol() - to.getCol() == 2 && from.getRow() == to.getRow()) {
				if (board.getSpot(to.getRow(), from.getCol() - 1).getPiece() != null
						|| board.getSpot(to.getRow(), from.getCol() - 2).getPiece() != null
						|| board.getSpot(to.getRow(), from.getCol() - 3).getPiece() != null) {
					castled = false;
					return false;
				}

			} else {
				castled = false;
				return false;
			}

			castled = true;

		}

		return true;
	}

	@Override
	public String toString() {
		if (this.isWhite())
			return "wK";
		else
			return "bK";
	}
}
