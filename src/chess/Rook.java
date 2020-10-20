package chess;

public class Rook extends Piece {

	public Rook(boolean white) {
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
		if (this.isWhite()) return "wR";
		else return "bR";
	}
}
