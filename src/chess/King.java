package chess;

public class King extends Piece {
	public boolean castled;

	public King(boolean white) {
		super(white);
		castled = false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		// TODO Auto-generated method stub

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
