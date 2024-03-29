package chess;

/**
 * Board class containing spots and logic
 * 
 * @author Mustafa Sadiq (ms3035)
 * @author Robert Mannifield (rmm288)
 *
 */
public class Board {
	/**
	 * Spots field
	 */
	Spot[][] spots;

	/**
	 * Constructor for Board creating a new board with default spots
	 */
	public Board() {
		spots = new Spot[8][8];
		setBoard();
	}

	/**
	 * get spot 
	 * 
	 * @param row Row
	 * @param col Column
	 * @return Spot return spot at row column
	 */
	public Spot getSpot(int row, int col) {
		return spots[row][col];
	}

	/**
	 * Constructor for Board creating a Board from given spot array
	 * @param value Spot array from another board
	 */
	public Board(Spot[][] value) {
		this.spots = value;
	}

	/**
	 * setter for Spot at row col
	 * 
	 * @param row Row
	 * @param col Column
	 * @param spot Spot
	 */
	private void setSpot(int row, int col, Spot spot) {
		spots[row][col] = spot;
	}

	/**
	 * Clones the board
	 */
	public Board clone() {
		Board clone = new Board();

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				clone.setSpot(row, col, spots[row][col].clone());
			}
		}

		return clone;
	}

	/**
	 * Sets the board to default setting
	 */
	public void setBoard() {
		// initialize white pieces
		spots[0][0] = new Spot(0, 0, new Rook(true));
		spots[0][1] = new Spot(0, 1, new Knight(true));
		spots[0][2] = new Spot(0, 2, new Bishop(true));
		spots[0][3] = new Spot(0, 3, new Queen(true));
		spots[0][4] = new Spot(0, 4, new King(true));
		spots[0][5] = new Spot(0, 5, new Bishop(true));
		spots[0][6] = new Spot(0, 6, new Knight(true));
		spots[0][7] = new Spot(0, 7, new Rook(true));
//
		spots[1][0] = new Spot(1, 0, new Pawn(true));
		spots[1][1] = new Spot(1, 1, new Pawn(true));
		spots[1][2] = new Spot(1, 2, new Pawn(true));
		spots[1][3] = new Spot(1, 3, new Pawn(true));
		spots[1][4] = new Spot(1, 4, new Pawn(true));
		spots[1][5] = new Spot(1, 5, new Pawn(true));
		spots[1][6] = new Spot(1, 6, new Pawn(true));
		spots[1][7] = new Spot(1, 7, new Pawn(true));

		// initialize black pieces
		spots[7][0] = new Spot(7, 0, new Rook(false));
		spots[7][1] = new Spot(7, 1, new Knight(false));
		spots[7][2] = new Spot(7, 2, new Bishop(false));
		spots[7][3] = new Spot(7, 3, new Queen(false));
		spots[7][4] = new Spot(7, 4, new King(false));
		spots[7][5] = new Spot(7, 5, new Bishop(false));
		spots[7][6] = new Spot(7, 6, new Knight(false));
		spots[7][7] = new Spot(7, 7, new Rook(false));
//
		spots[6][0] = new Spot(6, 0, new Pawn(false));
		spots[6][1] = new Spot(6, 1, new Pawn(false));
		spots[6][2] = new Spot(6, 2, new Pawn(false));
		spots[6][3] = new Spot(6, 3, new Pawn(false));
		spots[6][4] = new Spot(6, 4, new Pawn(false));
		spots[6][5] = new Spot(6, 5, new Pawn(false));
		spots[6][6] = new Spot(6, 6, new Pawn(false));
		spots[6][7] = new Spot(6, 7, new Pawn(false));

//		for debugging 
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				if (spots[i][j] == null) {
//					spots[i][j] = new Spot(i, j, null);
//				}
//
//			}
//		}

		// initialize remaining boxes without any piece
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				spots[i][j] = new Spot(i, j, null);
			}
		}

	}

	/**
	 * Print the board
	 * @param lines boolean to if print lines before and after
	 */
	public void printBoard(boolean lines) {

		if (lines)
			System.out.println();
		boolean hashtags = true;

		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j <= 8; j++) {
				if (j != 8) {
					if (spots[i][j].getPiece() != null) {
						System.out.print(spots[i][j] + " ");
						hashtags = !hashtags;
					} else {
						if (!hashtags) {
							System.out.print("##" + " ");
						} else {
							System.out.print("  " + " ");
						}
						hashtags = !hashtags;
					}
				} else {
					hashtags = !hashtags;
					System.out.print(i + 1);
				}
			}
			System.out.println();
		}
		System.out.println(" a  b  c  d  e  f  g  h");
		if (lines)
			System.out.println();

		// System.out.println("Black king: " + getKingSpot(false));
		// System.out.println("White king: " + getKingSpot(true));
	}

	/**
	 * getter for King spot
	 * @param isWhite white or black boolean
	 * @return Spot spot of King (white or black)
	 */
	public Spot getKingSpot(boolean isWhite) {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (getSpot(row, col).getPiece() instanceof King && getSpot(row, col).getPiece().isWhite() == isWhite) {
					return getSpot(row, col);
				}
			}
		}
		return new Spot(0, 0, null);
	}

	/**
	 * is white or black in check
	 * @param isWhite white or black boolean
	 * @return boolean yes or no
	 */
	public boolean isInCheck(boolean isWhite) {
		Spot kingPos = getKingSpot(isWhite);
		// System.out.println(kingPos);

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (getSpot(row, col).getPiece() != null && getSpot(row, col).getPiece().isWhite() == !isWhite) {
					if (getSpot(row, col).getPiece().canMove(this, getSpot(row, col), kingPos)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * are any moves possible for given color
	 * @param isWhite white or black boolean
	 * @return boolean yes or no
	 */
	public boolean isMovePossible(Boolean isWhite) {
		// System.out.println("\nmovesPossible\n");

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				// Spot (x,y)
				for (int z = 0; z < 8; z++) {
					for (int w = 0; w < 8; w++) {
						// Spot (z, w)
						if (getSpot(x, y).getPiece() != null && x + y != z + w) {
							if (getSpot(x, y).getPiece().isWhite() == isWhite) {

								try {
									// System.out.println("Tring move from: " + x + " " + y + " " + getSpot(x,
									// y).getPiece() + " to: " + z + " " + w + " " + getSpot(z, w).getPiece());

									tryMove(getSpot(x, y), getSpot(z, w), isWhite, false);

									// System.out.println(getSpot(x,y));

									return true;
								} catch (IllegalMoveException e) {

								}
							}
						}
					}
				}
			}
		}
		// System.out.println("\nmovesPossible\n");
		return false;
	}

	/**
	 * try moving spotFrom to spotTo and only make move if makeMove is true
	 * @param from Spot from
	 * @param to Spot to
	 * @param whiteTurn whiteTurn?
	 * @param makeMove makeMove?
	 */
	public void tryMove(Spot from, Spot to, boolean whiteTurn, boolean makeMove) {

		if (from.getPiece() == null) {
			throw new IllegalMoveException("No piece to move! Try again!");
		}

		else if (whiteTurn != from.getPiece().isWhite()) {
			throw new IllegalMoveException("Can't move opponent piece! Try again");
		}

		else if (to.getPiece() != null && from.getPiece().isWhite() == to.getPiece().isWhite()) {
			throw new IllegalMoveException("Can't move to own piece! Try again");
		}

		else if (from.getPiece().canMove(this, from, to)) {
			if (from.getPiece() instanceof King && ((King) from.getPiece()).getCastled()) {
				if (isInCheck(whiteTurn)) {
					throw new IllegalMoveException("King cannot castle if in check");
				}

				if (to.getCol() > from.getCol()) {
					Board temp = this.clone();
					// temp.printBoard(true);
					temp.makeMove(temp.getSpot(from.getRow(), from.getCol()),
							temp.getSpot(to.getRow(), to.getCol() - 1));
					// temp.printBoard(true);
					if (temp.isInCheck(whiteTurn))
						throw new IllegalMoveException("King will be in check in between");

				} else if (to.getCol() < from.getCol()) {
					Board temp = this.clone();
					// temp.printBoard(true);
					temp.makeMove(temp.getSpot(from.getRow(), from.getCol()),
							temp.getSpot(to.getRow(), to.getCol() + 1));
					// temp.printBoard(true);
					if (temp.isInCheck(whiteTurn))
						throw new IllegalMoveException("King will be in check in between");
				}
			}

			Board temp = this.clone();
			// temp.printBoard(true);
			temp.makeMove(temp.getSpot(from.getRow(), from.getCol()), temp.getSpot(to.getRow(), to.getCol()));
			// temp.printBoard(true);

			if (temp.isInCheck(whiteTurn))
				throw new IllegalMoveException("King will be in danger");

			if (makeMove) {
				// System.out.println("Making move");

				if (from.getPiece() instanceof Pawn && ((Pawn) from.getPiece()).getEnpassant()) {
					getSpot(from.getRow(), to.getCol()).setPiece(null);
				}

				if (from.getPiece() instanceof King && ((King) from.getPiece()).getCastled()) {
					if (to.getCol() - from.getCol() == 2) {
						if (to.getRow() == 0) {
							getSpot(0, 5).setPiece(getSpot(0, 7).getPiece());
							getSpot(0, 7).setPiece(null);
						} else if (to.getRow() == 7) {
							getSpot(7, 5).setPiece(getSpot(7, 7).getPiece());
							getSpot(7, 7).setPiece(null);
						}

					} else if (from.getCol() - to.getCol() == 2) {
						if (to.getRow() == 0) {
							getSpot(0, 3).setPiece(getSpot(0, 3).getPiece());
							getSpot(0, 0).setPiece(null);
						} else if (to.getRow() == 7) {
							getSpot(7, 3).setPiece(getSpot(7, 3).getPiece());
							getSpot(7, 0).setPiece(null);
						}
					}
				}

				makeMove(from, to);
			}

			else

			{
				if (from.getPiece() instanceof King) {
					((King) from.getPiece()).setCastled(false);
				}

				if (from.getPiece() instanceof Pawn) {
					((Pawn) from.getPiece()).setEnpassant(false);
					((Pawn) from.getPiece()).setJustdoublemove(false);

				}
			}

		}

		else

		{
			throw new IllegalMoveException("Illegal move, try again");
		}

	}

	/**
	 * Makes the move and resets Pawn and King
	 * @param from move from spot
	 * @param to move to spot
	 */
	public void makeMove(Spot from, Spot to) {
		if (from.getPiece() instanceof Pawn && Math.abs(to.getRow() - from.getRow()) == 2) {
			((Pawn) from.getPiece()).setJustdoublemove(true);
		}

		if (from.getPiece() instanceof King) {
			((King) from.getPiece()).setCastled(false);
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (spots[i][j].getPiece() != null) {
					if (spots[i][j].getPiece() instanceof Pawn
							&& spots[i][j].getPiece().isWhite() != from.getPiece().isWhite()) {
						((Pawn) spots[i][j].getPiece()).setJustdoublemove(false);
					}
				}
			}
		}

		from.getPiece().setHasMoved(true);
		to.setPiece(from.getPiece());
		from.setPiece(null);
	}

}
