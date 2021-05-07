package nLayeredDemo.core.concretes;

import GoogleAuth.GoogleAuthorizationManager;
import nLayeredDemo.core.abstracts.AuthorizationService;

public class GoogleAuthorizationManagerAdapter implements AuthorizationService {

	@Override
	public void authToSystem(String message) {
		GoogleAuthorizationManager googleAuthorizationManager = new GoogleAuthorizationManager();
		googleAuthorizationManager.Auth(message);
		
	}

}
