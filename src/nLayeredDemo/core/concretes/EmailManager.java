package nLayeredDemo.core.concretes;

import nLayeredDemo.core.abstracts.LoggerService;
import nLayeredDemo.entities.concretes.User;
 

public class EmailManager implements LoggerService {

	@Override
	public void logSuccess(User user) {
		System.out.println("Linke t�kla. Kay�t ba�ar�l�:" + user.getName());
	}
	public void logError(User user) {
		System.out.println("Kay�t ba�ar�s�z:" + user.getName());
	}
 

}
