package nLayeredDemo;

import nLayeredDemo.business.abstracts.UserService;
import nLayeredDemo.business.concretes.UserManager;
import nLayeredDemo.core.concretes.EmailManager;
import nLayeredDemo.core.concretes.GoogleAuthorizationManagerAdapter;
import nLayeredDemo.dataAccess.concretes.HibernateUserDao;
import nLayeredDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User(1, "ali", "keratin", "", "12345678");
		User user2 = new User(2, "veli", "argan", "veliargan@hotmail.com", "12345678");
		User user3 = new User(3, "celil", "minera", "celilminera@hotmail.com", "12345678");
		 
		UserService service = new UserManager(new HibernateUserDao(),new EmailManager(), new GoogleAuthorizationManagerAdapter());
		service.add(user);
		service.add(user2);
		service.add(user3);
		service.add(user3);
		service.add(user3);
		service.login(user2);
		service.login(user);
	 
		

	}

}
