package by.htp.library.dao.creator.impl;

import by.htp.library.bean.AgeTypeUser;
import by.htp.library.bean.StatusUser;
import by.htp.library.bean.User;
import by.htp.library.dao.creator.BookCreator;
import by.htp.library.dao.creator.UserCreator;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.impl.ParserUserParamFromStringImpl;
import by.htp.library.dao.validator.ValidatorStringUser;

public class UserCreatorImpl implements UserCreator{
	public User createUserByString(String userString) throws DAOLibraryException {
		if (!ValidatorStringUser.validateStringForCreateUser(userString)) {
			throw new DAOLibraryException("User could not be created");
		}
		int id;
		String login;
		String password;
		String name;
		StatusUser status;
		AgeTypeUser type;

		ParserUserParamFromStringImpl paramFromString = new ParserUserParamFromStringImpl();
		String[] paramUser = paramFromString.parseUserFromString(userString);

		if (paramUser[0].matches("\\d+")) {
			id = Integer.valueOf(paramUser[0]);
		} else {
			id = 0;
		}
		login = paramUser[1];
		password = paramUser[2];
		name = paramUser[3];
		switch (paramUser[4].toUpperCase()) {
		case "ADMIN": {
			status = StatusUser.ADMIN;
			break;
		}
		case "GUEST": {
			status = StatusUser.GUEST;
			break;
		}

		default: {
			status = StatusUser.UNDEFINITE;
		}
		}
		switch (paramUser[5].toUpperCase()) {
		case "PARENT": {
			type = AgeTypeUser.PARENT;
			break;
		}
		case "CHILD": {
			type = AgeTypeUser.CHILD;
			break;
		}

		default: {
			type = AgeTypeUser.UNDEFINITE;
		}
		}

		User user = new User(id, login, password, name, status, type);

		return user;

	}

}
