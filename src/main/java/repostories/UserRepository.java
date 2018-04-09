package repostories;

import java.util.ArrayList;
import java.util.List;

import domain.Permissions;
import domain.User;

public class UserRepository implements IamUserRepository {

	private static List<User> db = new ArrayList<User>();
	
	public UserRepository() {
		if (db.isEmpty()) {
			User user1 = new User();
			user1.setUsername("Admin");
			user1.setPassword("qwerty");
			user1.setEmail("administrator@administrator");
			user1.setPermissions(Permissions.ADMIN);
			
			User user2 = new User();
			user2.setUsername("Premium");
			user2.setPassword("qwerty");
			user2.setEmail("premium@premium");
			user2.setPermissions(Permissions.PREMIUM);
			
			User user3 = new User();
			user3.setUsername("Usual");
			user3.setPassword("qwerty");
			user3.setEmail("usual@usual");
			user3.setPermissions(Permissions.NORMAL);
			
			User user4 = new User();
			user4.setUsername("Casual");
			user4.setPassword("qwerty");
			user4.setEmail("casual@casual");
			user4.setPermissions(Permissions.NORMAL);
			
			db.add(user1);
			db.add(user2);
			db.add(user3);
			db.add(user4);
		}
	}

	public void add (User user) {
		db.add(user);
	}
	
	public boolean logIn (User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername()) && userDb.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public List<User> getUsers() {
		return db;
	}
	
	public String getUserEmail(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				return userDb.getEmail();
			}
		}
		return "brak uzytkownika";
	}
	
	public String getUserPermission(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				return userDb.getPermissions().toString();
			}
		}
		return "brak uzytkownika";
	}
	
	public void setPremium(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				userDb.setPermissions(Permissions.PREMIUM);
			}
		}
	}
	
	public void removePremium(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				userDb.setPermissions(Permissions.NORMAL);
			}
		}
	}
}
