package nLayeredDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import nLayeredDemo.dataAccess.abstracts.UserDao;
import nLayeredDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users = new ArrayList<User>();
	 
	
	@Override
	public void add(User user) {
		System.out.println("add to database");
		users.add(user);
		
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kiþi güncellendi:" + user.getName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kiþi silindi:" + user.getName());
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	 
 

	 
	
}
