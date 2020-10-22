package chess;

public abstract class Piece {
	private boolean white;
	private boolean hasMoved;

	public Piece(boolean white) {
		this.white = white;
		this.hasMoved = false;
	}

	public boolean isWhite() {
		return this.white;
	}

	public boolean hasMoved() {
		return this.hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public abstract boolean canMove(Board board, Spot from, Spot to);
}
