package nLayeredDemo.core.abstracts;

import nLayeredDemo.entities.concretes.User;

public interface LoggerService {

	void logSuccess(User user);
	void logError(User user);
}
