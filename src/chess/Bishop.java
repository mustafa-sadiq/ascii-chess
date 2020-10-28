package chess;

public class Bishop extends Piece {

	public Bishop(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot from, Spot to) {
		// TODO Auto-generated method stub
		if (from.getRow() == to.getRow() || from.getCol() == to.getCol()) {
			return false;
		} else if (Math.abs(from.getRow() - to.getRow()) != Math.abs(from.getCol() - to.getCol())) {
			return false;
		}

		int rowOffset, colOffset;

		if (from.getRow() < to.getRow()) {
			rowOffset = 1;
		} else {
			rowOffset = -1;
		}

		if (from.getCol() < to.getCol()) {
			colOffset = 1;
		} else {
			colOffset = -1;
		}

		int col = from.getCol() + colOffset;
		for (int row = from.getRow() + rowOffset; row != to.getRow(); row += rowOffset) {

			if (board.getSpot(row, col).getPiece() != null) {
				// System.out.println("Can not jump over piece.");
				return false;
			}

			col += colOffset;
		}
		return true;
	}

	@Override
	public String toString() {
		if (this.isWhite())
			return "wB";
		else
			return "bB";
	}

}
