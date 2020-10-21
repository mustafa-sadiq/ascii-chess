package chess;

public abstract class Piece {
	private boolean killed;
	private boolean white;
	private boolean hasMoved;

	public Piece(boolean white) {
		this.killed = false;
		this.white = white;
		this.hasMoved = false;
		
	}

	public boolean isWhite() {
		return this.white;
	}

	public void setWhite(boolean white) {
		this.white = white;
	}

	public boolean isKilled() {
		return this.killed;
	}

	public void setKilled(boolean killed) {
		this.killed = killed;
	}
	
	public boolean hasMoved() {
		return this.hasMoved;
	}
	
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public abstract boolean canMove(Board board, Spot start, Spot end);
}
