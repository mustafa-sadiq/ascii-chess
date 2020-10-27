package chess;

public class Pawn extends Piece {

	private boolean enpassant;
	private boolean justdoublemove;

	public boolean getJustdoublemove() {
		return justdoublemove;
	}

	public void setJustdoublemove(boolean justdoublemove) {
		this.justdoublemove = justdoublemove;
	}

	public boolean getEnpassant() {
		return enpassant;
	}

	public void setEnpassant(boolean value) {
		enpassant = value;
	}

	public Pawn(boolean white) {
		super(white);
		enpassant = false;
		justdoublemove = false;
		// TODO Auto-generated constructor stub
	}

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
				
				if ((from.getPiece().isWhite() && from.getRow() == 4) || (!from.getPiece().isWhite() && from.getRow() == 3)) {
					if (to.getCol() + 1 < 8) {
						if (board.getSpot(to.getRow(), to.getCol() + 1).getPiece() != null) {
							if (board.getSpot(to.getRow(), to.getCol() + 1).getPiece() instanceof Pawn
									&& ((Pawn) board.getSpot(to.getRow(), to.getCol() + 1).getPiece()).justdoublemove) {
								System.out.println("Enpassant true");
								enpassant = true;
							}
						}
					}

					else if (to.getCol() - 1 > 0) {
						if (board.getSpot(to.getRow(), to.getCol() - 1).getPiece() != null) {
							if (board.getSpot(to.getRow(), to.getCol() - 1).getPiece() instanceof Pawn
									&& ((Pawn) board.getSpot(to.getRow(), to.getCol() - 1).getPiece()).justdoublemove) {
								System.out.println("Enpassant true");
								enpassant = true;
							}
						}
					}

				}

				System.out.println(enpassant);
				if (!enpassant) return false;
				
				
			}

		}

		return true;
	}

	@Override
	public String toString() {
		if (this.isWhite())
			return "wp";
		else
			return "bp";
	}

}
