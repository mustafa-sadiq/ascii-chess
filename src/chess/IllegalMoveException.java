package chess;


public class IllegalMoveException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalMoveException() {
		super();
	}

	public IllegalMoveException(String value) {
		// TODO Auto-generated constructor stub
		super();
		//System.out.println(value);
		// System.out.println("Illegal move, try again");
	}

}
