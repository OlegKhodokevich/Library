package by.htp.library.dao.parser.impl;

import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.ParserBookParamFromString;
import by.htp.library.dao.validator.ValidatorStingBook;

public class ParserBookParamFromStringImpl implements ParserBookParamFromString{
	private static final String DELIMITER = "/"; // 1/Tatiana Polyakova/Mansion with access to the astral plane/detective/2021/paper/all/home

		@Override
	public String[] parseBookParamFromString(String line) throws DAOLibraryException {
		if (!ValidatorStingBook.validateStringBook(line)) {
			throw new DAOLibraryException("Illegal line for book.");
		}

		String[] paramUser = line.split(DELIMITER);
		return paramUser;
	}
}
