package by.htp.library.dao.parser;

import by.htp.library.dao.exception.DAOLibraryException;

public interface ParserBookParamFromString {
	public String[] parseBookParamFromString(String line) throws DAOLibraryException;
}
