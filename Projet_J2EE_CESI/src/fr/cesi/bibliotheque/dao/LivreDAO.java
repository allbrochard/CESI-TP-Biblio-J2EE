package fr.cesi.bibliotheque.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.cesi.bibliotheque.entity.Livre;
import fr.cesi.bibliotheque.exception.UnknownLivreException;



public class LivreDAO {
	
	private static List<Livre> livres = new ArrayList<Livre>();
	private static Long idSequence = 1L;
	
	private LivreDAO() { }
	
	
	public static void addLivre(Livre livre) {
		livre.setId(idSequence++);
		livres.add(livre);
	}
	
	
	public static void updateLivre(Livre livre) throws UnknownLivreException {
		int index = getLivreIndexById(livre.getId());
		if(index > -1) {
			livres.set(index, livre);
		} else {
			throw new UnknownLivreException(livre.getId());
		}
	}
	

	public static void updateUserIDLivre(Livre livre, long idUser, String nomUser) throws UnknownLivreException {
		livre.setIdUser(idUser);
		livre.setNomUser(nomUser);
		int index = getLivreIndexById(livre.getId());
		if(index > -1) {
			livres.set(index, livre);
		} else {
			throw new UnknownLivreException(livre.getId());
		}
	}

	public static void unLockUserIDLivre(Livre livre) throws UnknownLivreException {
		livre.setIdUser(null);
		int index = getLivreIndexById(livre.getId());
		if(index > -1) {
			livres.set(index, livre);
		} else {
			throw new UnknownLivreException(livre.getId());
		}
	}
	
	public static Livre findLivreById(Long id) throws UnknownLivreException {
		int index = getLivreIndexById(id);
		if(index > -1) {
			Livre livre = livres.get(index);
			return livre;
		}
		throw new UnknownLivreException(id);
	}
	
	
	public static List<Livre> getAllLivres() {
		return Collections.unmodifiableList(livres);
	}
	
	
	public static void removeLivre(Livre livre) throws UnknownLivreException {
		removeLivre(livre.getId());
	}
	
	
	public static void removeLivre(Long id) throws UnknownLivreException {
		int index = getLivreIndexById(id);
		if(index > -1) {
			livres.remove(index);
		} else {
			throw new UnknownLivreException(id);
		}
	}
	
	private static int getLivreIndexById(Long id) {
		for (int i = 0; i < livres.size(); i++) {
			Livre livre = livres.get(i);
			if(livre.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

}
