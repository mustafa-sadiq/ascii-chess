package chess;

/**
 * Spot class which stores information of row col and the piece in that spot
 * 
 * @author Mustafa Sadiq (ms3035)
 * @author Robert Mannifield (rmm288)
 *
 */
public class Spot {
	/**
	 * Piece stored in the spot
	 */
	private Piece piece;
	/**
	 * Row of the spot
	 */
	private int row;
	/**
	 * Column of the spot
	 */
	private int col;

	/**
	 * Constructor creating a Spot with row, column and piece
	 * 
	 * @param row
	 * @param col
	 * @param piece
	 */
	public Spot(int row, int col, Piece piece) {
		this.piece = piece;
		this.row = row;
		this.col = col;
	}

	/**
	 * getter for Piece
	 * @return piece
	 */
	public Piece getPiece() {
		return this.piece;
	}

	/**
	 * setter for Piece
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * getter for Row
	 * @return row
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * getter for Column
	 * @return column
	 */
	public int getCol() {
		return this.col;
	}

	/**
	 * Clones the spot with same row column and type of piece
	 */
	public Spot clone() {
		if (this.piece instanceof Rook)
			return new Spot(row, col, new Rook(this.piece.isWhite()));
		else if (this.piece instanceof Knight)
			return new Spot(row, col, new Knight(this.piece.isWhite()));
		else if (this.piece instanceof Queen)
			return new Spot(row, col, new Queen(this.piece.isWhite()));
		else if (this.piece instanceof Bishop)
			return new Spot(row, col, new Bishop(this.piece.isWhite()));
		else if (this.piece instanceof Pawn) {
			Pawn clone = new Pawn(this.piece.isWhite());
			clone.setEnpassant(((Pawn) this.getPiece()).getEnpassant());
			clone.setJustdoublemove(((Pawn) this.getPiece()).getJustdoublemove());
			return new Spot(row, col, clone);
		} else if (this.piece instanceof King) {
			King clone = new King(this.piece.isWhite());
			clone.setCastled(((King) this.piece).getCastled());
			return new Spot(row, col, clone);
		} else
			return new Spot(row, col, null);

	}

	/**
	 * Prints piece or null if no piece
	 */
	public String toString() {
		if (piece == null) {
			return "null";
		} else {
			return piece.toString();
		}

	}
}
