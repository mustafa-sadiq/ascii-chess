package chess;

/**
 * Piece abstract class
 * 
 * @author Mustafa Sadiq (ms3035)
 * @author Robert Mannifield (rmm288)
 *
 */
public abstract class Piece {
	/**
	 * White boolean if the piece is white or not
	 */
	private boolean white;
	/**
	 * Moved boolean if the piece has moved yet or not
	 */
	private boolean moved;
	/**
	 * Creates a new Piece (white or black)
	 * 
	 * @param white is white or not
	 */
	public Piece(boolean white) {
		this.white = white;
		this.moved = false;
	}

	/**
	 * @return Piece is white or not
	 */
	public boolean isWhite() {
		return this.white;
	}

	/**
	 * @return Piece moved yet or not
	 */
	public boolean hasMoved() {
		return this.moved;
	}

	/**
	 * Setter for moved
	 * 
	 * @param value moved yet or not
	 */
	public void setHasMoved(boolean value) {
		this.moved = value;
	}

	/**
	 * Can the piece move on the given board from spot from to spot to
	 * @param board board on which trying move
	 * @param from spot from
	 * @param to spot to
	 * @return boolean yes or no
	 */
	public abstract boolean canMove(Board board, Spot from, Spot to);
}
