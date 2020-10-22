package chess;

public class Queen extends Piece {

	public Queen(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		return new Rook(this.isWhite()).canMove(board, start, end) || new Bishop(this.isWhite()).canMove(board, start, end);
	}
	@Override
	public String toString() {
		if (this.isWhite()) return "wQ";
		else return "bQ";
	}

}
