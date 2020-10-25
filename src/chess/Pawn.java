package chess;

public class Pawn extends Piece {
	
	private boolean enpassant;

	public Pawn(boolean white) {
		super(white);
		enpassant = false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot from, Spot to) {

		if (from.getPiece().isWhite()) {
			if (from.getRow() > to.getRow()) {
				return false;
			}
		} else {
			if (to.getRow() > from.getRow()) {
				return false;
			}
		}

		if (from.getCol() == to.getCol()) {
			// Not taking a piece
			if (from.getPiece().isWhite()) {
				if (board.getBox(from.getRow()+1, from.getCol()).getPiece() != null) {
					return false;
				}
			} else {
				if (board.getBox(from.getRow()-1, from.getCol()).getPiece() != null) {
					return false;
				}
			}

			if (Math.abs(to.getRow() - from.getRow()) > 2) {
				return false;
			} else if (Math.abs(to.getRow() - from.getRow()) == 2) {
				// Advancing two spaces at beginning
				if (from.getPiece().hasMoved()) {
					return false;
				}

				if (from.getPiece().isWhite()) {
					if (board.getBox(from.getRow()+2, from.getCol()).getPiece() != null) {
						return false;
					}
				} else {
					if (board.getBox(from.getRow()-2, from.getCol()).getPiece() != null) {
						return false;
					}
				}

				 

			}
		} else {
			// Taking a piece
			if (Math.abs(to.getCol() - from.getCol()) != 1 || Math.abs(to.getRow() - from.getRow()) != 1) {
				return false;
			}

			if (board.getBox(to.getRow(), to.getCol()).getPiece() == null) {
				return false;
			}
		}

		return true;

	}

	@Override
	public String toString() {
		if (this.isWhite())
			return "wp";
		else
			return "bp";
	}

}
