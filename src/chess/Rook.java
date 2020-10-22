package chess;

public class Rook extends Piece {

	public Rook(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

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
				if (board.getBox(from.getRow(), i).getPiece() != null)

					return false;
			}
		} else if (from.getCol() == to.getCol()) {
			int direction;
			if (from.getRow() < to.getRow())
				direction = 1;
			else
				direction = -1;
			for (int i = from.getRow() + direction; i != to.getRow(); i += direction) {
				if (board.getBox(i, from.getCol()).getPiece() != null)

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
