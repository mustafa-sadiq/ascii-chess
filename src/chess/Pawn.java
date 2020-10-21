package chess;

public class Pawn extends Piece {

	public Pawn(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		int deltaX = Math.abs(start.getX()-end.getX());
		int deltaY = Math.abs(start.getY()-end.getY());

		
		if (start.getY() == 1 || start.getY() == 6 && deltaX == 0 && end.getPiece() == null) {
			return true;
		} else if (deltaY == 1 && deltaX == 0 && end.getPiece() == null) {
			return true;
		} else if (deltaX == 1 && deltaY == 1 && end.getPiece() != null) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	@Override
	public String toString() {
		if (this.isWhite()) return "wp";
		else return "bp";
	}

}
