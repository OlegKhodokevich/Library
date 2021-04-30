package by.htp.library.dao.parser.impl;

import by.htp.library.bean.AgeTypeUser;
import by.htp.library.bean.StatusUser;
import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.ParserUserParamToString;
import by.htp.library.dao.validator.ValidatorStringUser;

public class ParserUserParamToStringImpl implements ParserUserParamToString {
	private static final String DELIMITER = "/"; // 3/Khodokevich_Safina/333ccc/Safina/guest/child

	public String parseUserParamToTXT(User user) throws DAOLibraryException {
		int id = user.getId();
		String login = user.getLogin();
		String password = user.getPassword();
		String name = user.getName();
		StatusUser status = user.getStatus();
		AgeTypeUser type = user.getType();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(id);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(login);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(password);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(name);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(status);
		stringBuilder.append(DELIMITER);
		stringBuilder.append(type);

		if (!ValidatorStringUser.validateStringForCreateUser(stringBuilder.toString())) {
			throw new DAOLibraryException(" User has invalide param. User " + stringBuilder.toString());
		}

		return stringBuilder.toString();
	}

}
