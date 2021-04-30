package by.htp.library.dao;

import java.util.Optional;

import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOLibraryException;

public interface UserDAO {

	Optional<User> signIn(String login, String password) throws DAOLibraryException;
	
	boolean registration(User user) throws DAOLibraryException;
	
	boolean editUser(String login, String password, User substituteUser) throws DAOLibraryException;
	
	boolean removeUser(String login, String password) throws DAOLibraryException;
	
}
