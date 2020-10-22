package chess;

public class Knight extends Piece {

	public Knight(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot from, Spot to) {
		int deltaRow = Math.abs(from.getRow() - to.getRow());
		int deltaCol = Math.abs(from.getCol() - to.getCol());
		return deltaRow * deltaCol == 2;
	}

	@Override
	public String toString() {
		if (this.isWhite())
			return "wN";
		else
			return "bN";
	}
}
