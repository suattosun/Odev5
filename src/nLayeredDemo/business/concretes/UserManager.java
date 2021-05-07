package nLayeredDemo.business.concretes;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import nLayeredDemo.business.abstracts.UserService;
import nLayeredDemo.core.abstracts.AuthorizationService;
import nLayeredDemo.core.abstracts.LoggerService;
import nLayeredDemo.dataAccess.abstracts.UserDao;
import nLayeredDemo.entities.concretes.User;

public class UserManager implements UserService{

	UserDao userDao;
	LoggerService loggerService;
	AuthorizationService authorizationService;
	public UserManager(UserDao userDao, LoggerService loggerService, AuthorizationService authorizationService) {
		super();
		this.userDao = userDao;
		this.loggerService = loggerService;
		this.authorizationService = authorizationService;
	}

	@Override
	public void add(User user) {
		if(checkNameIsEmpty(user.getName()) && checkNameLength(user.getName()) 
				&& checkSurNameIsEmpty(user.getSurName()) && checkSurNameLength(user.getSurName())
				&& checkEmailIsEmpty(user.getEmail()) && checkEmailPattern(user.getEmail()) && checkUnusedEmailValidation(user.getEmail()) 
				&&  checkPasswordIsCorrectLenght(user.getPassword()) &&  checkPasswordIsEmpty(user.getPassword()) )
		{
			authorizationService.authToSystem("Google ile giriþ yapýldý:" + user.getName());
			this.loggerService.logSuccess(user);
			this.userDao.add(user);
			 
			return;
		}
		this.loggerService.logError(user);
		 
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void login(User user) {
		if(checkEmailIsEmpty(user.getEmail()) && checkPasswordIsEmpty(user.getPassword())){
			System.out.println("Giriþ yapýldý.");
			return;
		}
		System.out.println("Email veya parola hatalý.");
			 
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}
	private Boolean checkNameIsEmpty(String userName) {
		if(!userName.isEmpty())
		{
			return true;
		}
		return false;
	}
	private Boolean checkNameLength(String userName) {
		if(userName.length() > 2)
		{
			return true;
		}
		return false;
	}
	private Boolean checkSurNameIsEmpty(String surName) {
		if(!surName.isEmpty())
		{
			return true;
		}
		return false;
	}
	private Boolean checkSurNameLength(String surName) {
		if( surName.length() > 2)
		{
			return true;
		}
		return false;
	}
	private Boolean checkEmailIsEmpty(String email) {
 
		if(!email.isEmpty() )
		{
			return true;
		}
		return false;
	}
	private Boolean checkEmailPattern(String email) {
		 
		if( Pattern.matches("^(.+)@(.+.)[.](.+)$", email) )
		{
			return true; 
		}
		return false;
	}
	private Boolean checkUnusedEmailValidation(String email) {
		
		if(!userDao.getAll().stream().anyMatch(u -> u.getEmail().equals(email)))
		{
			return true;
		}
		return false;
	}
	private Boolean checkPasswordIsEmpty(String password) {
		
		if(!password.isEmpty() )
		{
			return true;
		}
		return false;
	}
	private Boolean checkPasswordIsCorrectLenght(String password) {
		
		if( password.length() > 6)
		{
			return true;
		}
		return false;
	}


	 
	 

}
