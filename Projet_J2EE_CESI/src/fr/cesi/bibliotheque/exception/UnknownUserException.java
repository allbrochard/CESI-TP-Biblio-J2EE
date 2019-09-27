package fr.cesi.bibliotheque.exception;

public class UnknownUserException extends RuntimeException {

	private static final long serialVersionUID = -5034522564194578372L;

	
	public UnknownUserException(Long id) {
		super("The user with id=" + id + " doesn't exist.");
	}
	
}
