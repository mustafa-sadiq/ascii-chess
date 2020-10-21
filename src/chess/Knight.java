package chess;

public class Knight extends Piece {

	public Knight(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		int deltaX = Math.abs(start.getX() - end.getX());
		int deltaY = Math.abs(start.getY() - end.getY());
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
