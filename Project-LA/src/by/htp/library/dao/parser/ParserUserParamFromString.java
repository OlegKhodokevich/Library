package by.htp.library.dao.parser;

import by.htp.library.dao.exception.DAOLibraryException;

public interface ParserUserParamFromString {
	public String[] parseUserFromString(String line) throws DAOLibraryException;

}
