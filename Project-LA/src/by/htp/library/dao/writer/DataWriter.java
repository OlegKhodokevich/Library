package by.htp.library.dao.writer;

import java.util.List;

import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOLibraryException;

public interface DataWriter {
	public void writeUserInTXT(User user, String fileName) throws DAOLibraryException;
	
	public void writeAllUsersInTXT(List<String> listStringUsers, String fileName) throws DAOLibraryException;
}
