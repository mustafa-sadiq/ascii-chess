package chess;

public abstract class Piece {
	private boolean white;
	private boolean moved;

	public Piece(boolean white) {
		this.white = white;
		this.moved = false;
	}

	public boolean isWhite() {
		return this.white;
	}

	public boolean hasMoved() {
		return this.moved;
	}

	public void setHasMoved(boolean value) {
		this.moved = value;
	}

	public abstract boolean canMove(Board board, Spot from, Spot to);
}
