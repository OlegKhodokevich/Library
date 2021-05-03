package by.htp.library.service;

import java.util.List;
import java.util.Optional;

import by.htp.library.bean.User;
import by.htp.library.service.exception.ServiceLibraryException;

public interface ClientService {

	Optional<User> signIn(String login, String password) throws ServiceLibraryException;
	
	void signOut(String login, User userOut); 

	List<User> getAllUsers() throws ServiceLibraryException;

	boolean registration(User user) throws ServiceLibraryException;

	boolean editUser(String login, String password, User substituteUser) throws ServiceLibraryException;

	boolean removeUser(String login, String password) throws ServiceLibraryException;

}
