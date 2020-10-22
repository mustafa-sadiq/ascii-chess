package chess;

public class Knight extends Piece {

	public Knight(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot from, Spot to) {
		int deltaX = Math.abs(from.getRow() - to.getRow());
		int deltaY = Math.abs(from.getCol() - to.getCol());
		return deltaX * deltaY == 2;
	}

	@Override
	public String toString() {
		if (this.isWhite())
			return "wN";
		else
			return "bN";
	}
}
