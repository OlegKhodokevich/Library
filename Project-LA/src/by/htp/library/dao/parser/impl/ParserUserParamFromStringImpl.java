package by.htp.library.dao.parser.impl;

import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.ParserUserParamFromString;

public class ParserUserParamFromStringImpl implements ParserUserParamFromString {
	private static final String DELIMITER = "/|\\s"; // 3/Khodokevich_Safina/333ccc/Safina/guest/child

	public String[] parseUserFromString(String line) throws DAOLibraryException {

		String[] paramUser = line.split(DELIMITER);
		return paramUser;
	}

}
