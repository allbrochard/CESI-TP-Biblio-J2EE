package fr.cesi.bibliotheque.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.cesi.bibliotheque.entity.User;
import fr.cesi.bibliotheque.exception.UnknownUserException;



public class UserDAO {
	
	private static List<User> users = new ArrayList<User>();
	private static Long idSequence = 1L;
	
	private UserDAO() { }
	
	
	public static void addUser(User user) {
		user.setId(idSequence++);
		users.add(user);
	}
	
	
	public static void updateUser(User user) throws UnknownUserException {
		int index = getUserIndexById(user.getId());
		if(index > -1) {
			users.set(index, user);
		} else {
			throw new UnknownUserException(user.getId());
		}
	}
	
	
	public static User findUserById(Long id) throws UnknownUserException {
		int index = getUserIndexById(id);
		if(index > -1) {
			User user = users.get(index);
			return user;
		}
		throw new UnknownUserException(id);
	}
	
	
	public static List<User> getAllUsers() {
		return Collections.unmodifiableList(users);
	}
	
	
	public static void removeUser(User user) throws UnknownUserException {
		removeUser(user.getId());
	}
	
	
	public static void removeUser(Long id) throws UnknownUserException {
		int index = getUserIndexById(id);
		if(index > -1) {
			users.remove(index);
		} else {
			throw new UnknownUserException(id);
		}
	}
	
	private static int getUserIndexById(Long id) {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if(user.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

}
