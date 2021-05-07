package nLayeredDemo.business.abstracts;

import java.util.List;

import nLayeredDemo.entities.concretes.User;

public interface UserService {

	void add(User user);
	void delete(User user);
	void update(User user);
	void login(User user);
	List<User> getAll();
	 
}
