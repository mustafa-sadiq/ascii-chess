package chess;

public class Spot {
	private Piece piece;
	private int row;
	private int col;

	public Spot(int row, int col, Piece piece) {
		this.piece = piece;
		this.row = row;
		this.col = col;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

	public String toString() {
		if (piece == null) {
			return "null";
		} else {
			return piece.toString();
		}

	}
}
