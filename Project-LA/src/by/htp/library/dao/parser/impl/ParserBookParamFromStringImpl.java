package by.htp.library.dao.parser.impl;

import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.ParserBookParamFromString;

public class ParserBookParamFromStringImpl implements ParserBookParamFromString {
	private static final String DELIMITER = "/";

	@Override
	public String[] parseBookParamFromString(String line) throws DAOLibraryException {

		String[] paramUser = line.split(DELIMITER);
		return paramUser;
	}
}
