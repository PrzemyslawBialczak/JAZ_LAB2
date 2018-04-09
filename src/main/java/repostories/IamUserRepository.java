package repostories;

import java.util.List;

import domain.User;

public interface IamUserRepository {
	
	void add (User user);
	
	boolean logIn(User uer);
	
	List<User> getUsers();
	
	String getUserEmail(User user);
	
	String getUserPermission(User user);
	
	void setPremium (User user);
	
	void removePremium (User user);
}
