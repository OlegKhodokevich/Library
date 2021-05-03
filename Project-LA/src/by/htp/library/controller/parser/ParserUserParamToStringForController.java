package by.htp.library.controller.parser;

import by.htp.library.bean.AgeTypeUser;
import by.htp.library.bean.StatusUser;
import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.ParserUserParamToString;

public class ParserUserParamToStringForController implements ParserUserParamToString {
	private static final String DELIMITER = " ";

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

		return stringBuilder.toString();
	}

}
