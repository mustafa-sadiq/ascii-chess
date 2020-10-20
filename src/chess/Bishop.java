package chess;

public class Bishop extends Piece {

	public Bishop(boolean white) {
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
		if (this.isWhite()) return "wB";
		else return "bB";
	}

}
