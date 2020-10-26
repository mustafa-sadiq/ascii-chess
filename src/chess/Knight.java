package chess;

public class Knight extends Piece {

	public Knight(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot from, Spot to) {
		
		if(Math.abs(from.getRow() - to.getRow()) == 2 && Math.abs(from.getCol() - to.getCol()) == 1){
			return true;
		}
		
		if(Math.abs(from.getRow() - to.getRow()) == 1 && Math.abs(from.getCol() - to.getCol()) == 2){
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		if (this.isWhite())
			return "wN";
		else
			return "bN";
	}
}
