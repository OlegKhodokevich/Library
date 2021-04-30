package by.htp.library.dao;

import by.htp.library.dao.impl.TXTBookDAO;
import by.htp.library.dao.impl.TXTUserDAO;

public class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();
	private final BookDAO fileBookImpl = new TXTBookDAO();
	private final UserDAO fileUserImpl = new TXTUserDAO();

	private DAOProvider() {

	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public BookDAO getFileBookImpl() {
		return fileBookImpl;
	}

	public UserDAO getFileUserImpl() {
		return fileUserImpl;
	}

}
