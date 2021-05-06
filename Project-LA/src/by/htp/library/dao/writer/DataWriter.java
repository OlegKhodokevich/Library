package by.htp.library.dao.writer;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOLibraryException;

public interface DataWriter {
	void writeUserInTXT(User user, String fileName) throws DAOLibraryException;
	
	void writeAllUsersInTXT(List<String> listStringUsers, String fileName) throws DAOLibraryException;
	
	void writeBookInTXT(Book book, String fileName) throws DAOLibraryException;
	
	void writeAllBookInTXT(List<String> listBook, String fileName) throws DAOLibraryException;
	
	void writeNumberID(List<String> listNumber, String fileName) throws DAOLibraryException;
}
