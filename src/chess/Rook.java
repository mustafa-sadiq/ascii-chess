package chess;

public class Rook extends Piece {

	public Rook(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot from, Spot to) {
		// TODO Auto-generated method stub
		if (from.getRow() != to.getRow() || from.getCol() != to.getCol()) {
			return false;
		} else if (from.getRow() == to.getRow()) {
			for (int i = from.getCol(); i < to.getCol(); i++) {
				if (board.getBox(from.getRow(), i) != null)

					return false;
			}
		} else if (from.getCol() == to.getCol()) {
			for (int i = from.getRow(); i < to.getRow(); i++) {
				if (board.getBox(i, from.getCol()) != null)

					return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		if (this.isWhite())
			return "wR";
		else
			return "bR";
	}
}
