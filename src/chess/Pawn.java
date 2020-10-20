package chess;

public class Pawn extends Piece {

	public Pawn(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		return true;
	}
	
	@Override
	public String toString() {
		if (this.isWhite()) return "wp";
		else return "bp";
	}

}
