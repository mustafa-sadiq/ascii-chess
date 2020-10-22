package chess;

public class Pawn extends Piece {

	public Pawn(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot from, Spot to) {
		int deltaRow = Math.abs(from.getRow()-to.getRow());
		int deltaCol = Math.abs(from.getCol()-to.getCol());

		
		if (from.getRow() == 1 || from.getRow() == 6 && deltaCol == 0 && to.getPiece() == null) {
			return true;
		} else if (deltaCol == 1 && deltaRow == 0 && to.getPiece() == null) {
			return true;
		} else if (deltaCol == 1 && deltaRow == 1 && to.getPiece() != null) {
			return true;
		} else {
			return true;
		}
		
		
	}
	
	@Override
	public String toString() {
		if (this.isWhite()) return "wp";
		else return "bp";
	}

}
