package chess;

public class Bishop extends Piece {

	public Bishop(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		int deltaX = Math.abs(start.getX() - end.getX());
		int deltaY = Math.abs(start.getY() - end.getY());

		if (start.getY() == end.getY() || start.getX() == end.getX()) {
			return false;
		} else if (deltaY != deltaX) {
			return false;
		}

		int rowOffset, colOffset;

		if (start.getY() < end.getY()) {
			rowOffset = 1;
		} else {
			rowOffset = -1;
		}

		if (start.getX() < end.getX()) {
			colOffset = 1;
		} else {
			colOffset = -1;
		}

		int y = start.getX() + colOffset;
		for (int x = start.getY() + rowOffset; x != end.getY(); x += rowOffset) {

			if (board.getBox(x, y).getPiece() != null) {
				return false;
			}

			y += colOffset;
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
