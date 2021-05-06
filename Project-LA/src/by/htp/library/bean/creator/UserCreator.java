package by.htp.library.bean.creator;

import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOLibraryException;

public interface UserCreator {
	public User createUserByString(String userString) throws DAOLibraryException;

}
