package chess;

public class Board {
	Spot[][] spots;

	public Board() {
		spots = new Spot[8][8];
		resetBoard();
	}

	public Spot getSpot(int x, int y) {
		return spots[x][y];
	}

	public Board clone() {
		Board clone = new Board();
		clone.spots = this.spots.clone();
		return clone;
	}

	public void resetBoard() {
		// initialize white pieces
		spots[0][0] = new Spot(0, 0, new Rook(true));
		spots[0][1] = new Spot(0, 1, new Knight(true));
		spots[0][2] = new Spot(0, 2, new Bishop(true));
		spots[0][3] = new Spot(0, 3, new Queen(true));
		spots[0][4] = new Spot(0, 4, new King(true));
		spots[0][5] = new Spot(0, 5, new Bishop(true));
		spots[0][6] = new Spot(0, 6, new Knight(true));
		spots[0][7] = new Spot(0, 7, new Rook(true));

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
		spots[7][1] = new Spot(7, 1, new Knight(true));
		spots[7][2] = new Spot(7, 2, new Bishop(false));
		spots[7][3] = new Spot(7, 3, new Queen(false));
		spots[7][4] = new Spot(7, 4, new King(false));
		spots[7][5] = new Spot(7, 5, new Bishop(false));
		spots[7][6] = new Spot(7, 6, new Knight(false));
		spots[7][7] = new Spot(7, 7, new Rook(false));

		spots[6][0] = new Spot(6, 0, new Pawn(false));
		spots[6][1] = new Spot(6, 1, new Pawn(false));
		spots[6][2] = new Spot(6, 2, new Pawn(false));
		spots[6][3] = new Spot(6, 3, new Pawn(false));
		spots[6][4] = new Spot(6, 4, new Pawn(false));
		spots[6][5] = new Spot(6, 5, new Pawn(false));
		spots[6][6] = new Spot(6, 6, new Pawn(false));
		spots[6][7] = new Spot(6, 7, new Pawn(false));

		// initialize remaining boxes without any piece
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				spots[i][j] = new Spot(i, j, null);
			}
		}
	}

	public void printBoard() {
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

		// System.out.println("Black king: " + getKingSpot(false));
		// System.out.println("White king: " + getKingSpot(true));
	}

}
