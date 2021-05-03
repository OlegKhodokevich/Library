package by.htp.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.htp.library.bean.User;
import by.htp.library.dao.DAOProvider;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.service.ClientService;
import by.htp.library.service.exception.ServiceLibraryException;

public class ClientServiceImpl implements ClientService{
	private static final DAOProvider PROVIDER = DAOProvider.getInstance();
	private static final UserDAO USER_DAO = PROVIDER.getUserDAO();

	@Override
	public Optional<User> signIn(String login, String password) throws ServiceLibraryException {
		if (login == null || login.isEmpty()) {
			throw new ServiceLibraryException("Incorrect login");
		}
		Optional<User> user= null;
		try {
			user = USER_DAO.signIn(login, password);
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}
		
		return user;
	}

	@Override
	public List<User> getAllUsers() throws ServiceLibraryException {
		List<User> listUsers = new ArrayList<User>();
		try {
			listUsers = USER_DAO.getAllUsers();
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}		
		return listUsers;
	}

	@Override
	public boolean registration(User user) throws ServiceLibraryException {
		boolean result = false;
		
		try {
			result = USER_DAO.registration(user);
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}
		return result;
	}

	@Override
	public boolean editUser(String login, String password, User substituteUser) throws ServiceLibraryException {
		boolean result = false;
		
		try {
			result = USER_DAO.editUser(login, password, substituteUser);
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}
		
		return result;
	}

	@Override
	public boolean removeUser(String login, String password) throws ServiceLibraryException {
		boolean result = false;
		
		try {
			result = USER_DAO.removeUser(login, password);
		} catch (DAOLibraryException e) {
			throw new ServiceLibraryException(e);
		}
		
		return result;
	}

	@Override
	public void signOut(String login, User userOut) {
		if (userOut != null && login.equals(userOut.getLogin())) {
			userOut = null;			
		}		
	}
}
