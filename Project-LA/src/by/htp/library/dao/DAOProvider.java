package by.htp.library.dao;

import by.htp.library.dao.impl.TXTBookDAO;
import by.htp.library.dao.impl.TXTUserDAO;

public class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();
	private final BookDAO bookDAO = new TXTBookDAO();
	private final UserDAO userDAO = new TXTUserDAO();

	private DAOProvider() {

	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

}
