package by.htp.library.dao.creator.impl;

import by.htp.library.bean.AgeTypeUser;
import by.htp.library.bean.StatusUser;
import by.htp.library.bean.User;
import by.htp.library.dao.Creator;
import by.htp.library.dao.creator.UserCreator;
import by.htp.library.dao.exception.DAOLibraryException;

public class UserCreatorImpl implements UserCreator{
	public User createUserByString(String userString) throws DAOLibraryException {
		
		int id;
		String login;
		String password;
		String name;
		StatusUser status;
		AgeTypeUser type;
		
		User user = null;

		String[] paramUser = Creator.PARSER_USER_PARAM_FROM_STRING.parseUserFromString(userString);

		if (paramUser.length == 6) {
			id = Integer.valueOf(paramUser[0]);		
			login = paramUser[1];
			password = paramUser[2];
			name = paramUser[3];
			status = StatusUser.valueOf(paramUser[4].toUpperCase());
			type = AgeTypeUser.valueOf(paramUser[5].toUpperCase());

			user = new User(id, login, password, name, status, type);
		} else if (paramUser.length == 5) {			
			login = paramUser[0];
			password = paramUser[1];
			name = paramUser[2];
			status = StatusUser.valueOf(paramUser[3]);
			type = AgeTypeUser.valueOf(paramUser[4]);
			
			user = new User(login, password, name, status, type);
		}		

		return user;
	}
}
