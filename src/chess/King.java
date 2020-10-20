package chess;

public class King extends Piece {

	public King(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		if (this.isWhite()) return "wK";
		else return "bK";
	}
}
