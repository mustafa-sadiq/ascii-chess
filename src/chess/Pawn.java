package chess;

/**
 * Pawn class
 * 
 * @author Mustafa Sadiq (ms3035)
 * @author Robert Mannifield (rmm288)
 *
 */
public class Pawn extends Piece {

	/**
	 * is current move piece the capturing en passant
	 */
	private boolean enpassant;
	/**
	 * is piece last move and double
	 */
	private boolean justdoublemove;

	/**
	 * getter for justdoublemove
	 * @return justdoublemove
	 */
	public boolean getJustdoublemove() {
		return justdoublemove;
	}

	/**
	 * setter for justdoublemove
	 * @param justdoublemove boolean justdoublemove
	 */
	public void setJustdoublemove(boolean justdoublemove) {
		this.justdoublemove = justdoublemove;
	}

	/**
	 * getter for enpassant
	 * @return enpassant
	 */
	public boolean getEnpassant() {
		return enpassant;
	}

	/**
	 * setter for enpassant
	 * @param value boolean enpassant
	 */
	public void setEnpassant(boolean value) {
		enpassant = value;
	}

	/**
	 * Constructor for Pawn creating a white or black pawn
	 * @param white white or black
	 */
	public Pawn(boolean white) {
		super(white);
		enpassant = false;
		justdoublemove = false;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	@Override
	public boolean canMove(Board board, Spot from, Spot to) {

		// moving backward
		if (from.getPiece().isWhite()) {
			if (from.getRow() > to.getRow()) {
				return false;
			}
		} else {
			if (to.getRow() > from.getRow()) {
				return false;
			}
		}

		if (from.getCol() == to.getCol()) {
			// Not taking a piece
			if (from.getPiece().isWhite()) {
				if (board.getSpot(from.getRow() + 1, from.getCol()).getPiece() != null) {
					return false;
				}
			} else {
				if (board.getSpot(from.getRow() - 1, from.getCol()).getPiece() != null) {
					return false;
				}
			}

			if (Math.abs(to.getRow() - from.getRow()) > 2) {
				return false;
			} else if (Math.abs(to.getRow() - from.getRow()) == 2) {
				// Advancing two spaces at beginning
				if (from.getPiece().hasMoved()) {
					return false;
				}

				if (from.getPiece().isWhite()) {
					if (board.getSpot(from.getRow() + 2, from.getCol()).getPiece() != null) {
						return false;
					}
				} else {
					if (board.getSpot(from.getRow() - 2, from.getCol()).getPiece() != null) {
						return false;
					}
				}
				// System.out.println("Double move by pawn" + from.getPiece());
			}

		}

		else {
			// Taking a piece
			if (Math.abs(to.getCol() - from.getCol()) != 1 || Math.abs(to.getRow() - from.getRow()) != 1) {
				return false;
			}

			if (board.getSpot(to.getRow(), to.getCol()).getPiece() == null) {

				if ((from.getPiece().isWhite() && from.getRow() == 4)
						|| (!from.getPiece().isWhite() && from.getRow() == 3)) {

					// System.out.println("5th rank");

					if (to.getCol() < 8 || to.getCol() > 0) {
						if (board.getSpot(from.getRow(), to.getCol()).getPiece() != null
								&& board.getSpot(from.getRow(), to.getCol()).getPiece().isWhite() != from.getPiece()
										.isWhite()) {
							if (board.getSpot(from.getRow(), to.getCol()).getPiece() instanceof Pawn
									&& ((Pawn) board.getSpot(from.getRow(), to.getCol()).getPiece()).justdoublemove) {
								// System.out.println("Enpassant true");
								enpassant = true;
							}
						}
					}

				}

				if (!enpassant)
					return false;

			}

		}

		return true;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		if (this.isWhite())
			return "wp";
		else
			return "bp";
	}

}
