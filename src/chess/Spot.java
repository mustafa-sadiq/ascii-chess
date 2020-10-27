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

	public Spot clone() {
		if (this.piece instanceof Rook) return new Spot(row, col, new Rook(this.piece.isWhite()));
		else if (this.piece instanceof Knight) return new Spot(row, col, new Knight(this.piece.isWhite()));
		else if (this.piece instanceof Queen) return new Spot(row, col, new Queen(this.piece.isWhite()));
		else if (this.piece instanceof Bishop) return new Spot(row, col, new Bishop(this.piece.isWhite()));
		else if (this.piece instanceof Pawn) {
			Pawn clone = new Pawn(this.piece.isWhite());
			clone.setEnpassant(((Pawn) this.getPiece()).getEnpassant());
			return new Spot(row, col, clone);
		}
		else if  (this.piece instanceof King){
			King clone = new King(this.piece.isWhite());
			clone.setCastled(((King) this.piece).getCastled());
			return new Spot(row, col, clone);
		} else return new Spot(row, col, null);
		
	}

	public String toString() {
		if (piece == null) {
			return "null";
		} else {
			return piece.toString();
		}

	}
}
