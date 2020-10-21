package chess;

public class Bishop extends Piece {

	public Bishop(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		int deltaY = Math.abs(start.getX()-end.getX());
		int deltaX = Math.abs(start.getY()-end.getY());
		
		return deltaY == deltaX;
	}
	
	
	@Override
	public String toString() {
		if (this.isWhite()) return "wB";
		else return "bB";
	}

}
