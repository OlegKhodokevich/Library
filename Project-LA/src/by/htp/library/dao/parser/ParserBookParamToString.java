package by.htp.library.dao.parser;

import by.htp.library.bean.Book;
import by.htp.library.dao.exception.DAOLibraryException;

public interface ParserBookParamToString {
	public String parseBookParamToStringForTXT(Book book) throws DAOLibraryException;
}
