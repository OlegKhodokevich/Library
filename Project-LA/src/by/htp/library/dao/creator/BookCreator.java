package by.htp.library.dao.creator;

import by.htp.library.bean.Book;
import by.htp.library.dao.exception.DAOLibraryException;

public interface BookCreator {
	public Book createBookFromString(String bookString) throws DAOLibraryException;
}
