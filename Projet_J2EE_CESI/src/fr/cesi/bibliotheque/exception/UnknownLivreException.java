package fr.cesi.bibliotheque.exception;

public class UnknownLivreException extends RuntimeException {

	private static final long serialVersionUID = -5034522564194578372L;

	
	public UnknownLivreException(Long id) {
		super("The book with id=" + id + " doesn't exist.");
	}
	
}
