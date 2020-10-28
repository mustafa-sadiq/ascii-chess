package chess;

/**
 * IllegalMoveException (runtime) when a move is not possible
 * 
 * @author Mustafa Sadiq (ms3035)
 * @author Robert Mannifield (rmm288)
 *
 */
public class IllegalMoveException extends RuntimeException {
	/**
	 * required by eclipse
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A simple constructor
	 */
	public IllegalMoveException() {
		super();
	}

	/**
	 * A constructor which can display messages to debug
	 * 
	 * @param value String to print
	 */
	public IllegalMoveException(String value) {
		// TODO Auto-generated constructor stub
		super();
		// System.out.println(value);
		// System.out.println("Illegal move, try again");

		if (value.contains(" print"))
			System.out.println(value);
	}

}
