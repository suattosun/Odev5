package nLayeredDemo.core.concretes;

import nLayeredDemo.core.abstracts.LoggerService;
import nLayeredDemo.entities.concretes.User;
 

public class EmailManager implements LoggerService {

	@Override
	public void logSuccess(User user) {
		System.out.println("Linke týkla. Kayýt baþarýlý:" + user.getName());
	}
	public void logError(User user) {
		System.out.println("Kayýt baþarýsýz:" + user.getName());
	}
 

}
