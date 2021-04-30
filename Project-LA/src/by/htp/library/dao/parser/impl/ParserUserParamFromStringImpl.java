package by.htp.library.dao.parser.impl;

import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.ParserUserParamFromString;
import by.htp.library.dao.validator.ValidatorStringUser;

public class ParserUserParamFromStringImpl implements ParserUserParamFromString {
	private static final String DELIMITER = "/"; // 3/Khodokevich_Safina/333ccc/Safina/guest/child

	public String[] parseUserFromString(String line) throws DAOLibraryException {
		if (!ValidatorStringUser.validateStringForCreateUser(line)) {
			throw new DAOLibraryException("Illegal line for user.");
		}

		String[] paramUser = line.split(DELIMITER);

		return paramUser;
	}

}
