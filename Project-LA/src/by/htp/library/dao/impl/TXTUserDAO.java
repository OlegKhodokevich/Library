package by.htp.library.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.htp.library.bean.User;
import by.htp.library.dao.Creator;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.validator.ValidatorBookByParam;
import by.htp.library.dao.validator.ValidatorUserLogin;

public class TXTUserDAO implements UserDAO {
	private static final String FILE_SOURCE_USERS = "data/dataUsers.txt";
	private static final String FILE_SOURCE_NUMBER = "data/numberID.txt";

	@Override
	public Optional<User> signIn(String login, String password) throws DAOLibraryException {
		Optional<User> user = null;

		List<String> listUserString = Creator.DATA_READER.readAllUser(FILE_SOURCE_USERS);
		for (int i = 0; i < listUserString.size(); i++) {
			if (ValidatorUserLogin.validateStringLineByLoginAndPassword(listUserString.get(i), login, password)) {
				user = Optional.ofNullable(Creator.USER_CREATOR.createUserByString(listUserString.get(i)));
			}
		}

		return user;
	}

	@Override
	public List<User> getAllUsers() throws DAOLibraryException {
		List<User> listUsers = new ArrayList<User>();

		List<String> listUserString = Creator.DATA_READER.readAllUser(FILE_SOURCE_USERS);
		for (int i = 0; i < listUserString.size(); i++) {
			User user = Creator.USER_CREATOR.createUserByString(listUserString.get(i));
			listUsers.add(user);
		}

		return listUsers;
	}

	@Override
	public boolean registration(User user) throws DAOLibraryException {
		String login = user.getLogin();
		String password = user.getPassword();
		boolean flag = false;
		if (signIn(login, password) == null) {
			List<String> listNumber = Creator.DATA_READER.getNumberID(FILE_SOURCE_NUMBER);
			int counterId = Integer.valueOf(listNumber.get(0));
			user.setId(counterId);
			counterId++;
			listNumber.set(0, String.valueOf(counterId));
			Creator.DATA_WRITER.writeNumberID(listNumber, FILE_SOURCE_NUMBER);

			Creator.DATA_WRITER.writeUserInTXT(user, FILE_SOURCE_USERS);
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean editUser(String login, String password, User substituteUser) throws DAOLibraryException {
		boolean flag = false;
		List<String> listUserString = Creator.DATA_READER.readAllUser(FILE_SOURCE_USERS);

		for (int i = 0; i < listUserString.size(); i++) {
			if (ValidatorBookByParam.validateStringBookByNameAndAutor(listUserString.get(i), login, password)) {

				String[] paramUser = Creator.PARSER_USER_PARAM_FROM_STRING.parseUserFromString(listUserString.get(i));
				substituteUser.setId(Integer.valueOf(paramUser[0]) + 1);

				String newUserString = Creator.PARSER_USER_PARAM_TO_STRING.parseUserParamToTXT(substituteUser);
				listUserString.set(i, newUserString);

				Creator.DATA_WRITER.writeAllUsersInTXT(listUserString, FILE_SOURCE_USERS);
				flag = true;
			}
		}

		return flag;
	}

	@Override
	public boolean removeUser(String login, String password) throws DAOLibraryException {
		boolean flag = false;

		List<String> listUserString = Creator.DATA_READER.readAllUser(FILE_SOURCE_USERS);

		for (int i = 0; i < listUserString.size(); i++) {
			if (!flag && ValidatorUserLogin.validateStringLineByLoginAndPassword(listUserString.get(i), login,
					password)) {
				listUserString.remove(i);
				i = i - 1;

				flag = true;
			}
		}

		if (flag) {
			Creator.DATA_WRITER.writeAllUsersInTXT(listUserString, FILE_SOURCE_USERS);
		}

		return flag;
	}

}
