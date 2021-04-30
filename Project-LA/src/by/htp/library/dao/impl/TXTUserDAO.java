package by.htp.library.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import by.htp.library.bean.User;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.creator.impl.UserCreatorImpl;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.ParserUserParamFromString;
import by.htp.library.dao.parser.ParserUserParamToString;
import by.htp.library.dao.parser.impl.ParserUserParamFromStringImpl;
import by.htp.library.dao.parser.impl.ParserUserParamToStringImpl;
import by.htp.library.dao.reader.impl.DataReaderImpl;
import by.htp.library.dao.validator.ValidatorUserLogin;
import by.htp.library.dao.writer.DataWriter;
import by.htp.library.dao.writer.impl.DataWriterImp;

public class TXTUserDAO implements UserDAO {
	private static final String FILE_SOURCE_USER_NAME = "data/dataUsers.txt";
	
	private static final String UNDEFINITED_NAME = "undefined";
	private static final String DELIMITER = "/";

	@Override
	public Optional<User> signIn(String login, String password) throws DAOLibraryException {
		String userString = UNDEFINITED_NAME;
		

		DataReaderImpl dataReaderImpl = new DataReaderImpl();
		List<String> listUser = dataReaderImpl.readAllLegalUser(FILE_SOURCE_USER_NAME);
		userString = listUser.stream()
				.filter(s -> ValidatorUserLogin.validateStringLineByLoginAndPassword(s, login, password)).findFirst()
				.orElse("undefined");

		
		Optional<User> user =null;
		if (!userString.equals(UNDEFINITED_NAME)) {
			UserCreatorImpl userCreator = new UserCreatorImpl();
			user = Optional.ofNullable(userCreator.createUserByString(userString));
		}		

		return user;

	}

	@Override
	public boolean registration(User user) throws DAOLibraryException {
		String login = user.getLogin();
		String password = user.getPassword();
		boolean flag = false;
		if (signIn(login, password) == null) {
			DataReaderImpl dataReaderImpl = new DataReaderImpl();
			List<String> usersList = dataReaderImpl.readAllLegalUser(FILE_SOURCE_USER_NAME);

			ParserUserParamFromString parserUserParamFromString = new ParserUserParamFromStringImpl();
			String[] usersParam = parserUserParamFromString.parseUserFromString((usersList.get(usersList.size() - 1)));
			int lastID = Integer.valueOf(usersParam[0]);
			user.setId(lastID + 1);

			DataWriter dataWriter = new DataWriterImp();
			dataWriter.writeUserInTXT(user, FILE_SOURCE_USER_NAME);
			flag = true;
		} 
		
		return flag;	
	}

	@Override
	public boolean editUser(String login, String password, User substituteUser) throws DAOLibraryException {
		boolean flag = false;
		DataReaderImpl dataReaderImpl = new DataReaderImpl();
		List<String> listUser = dataReaderImpl.readAllLegalUser(FILE_SOURCE_USER_NAME);

		ParserUserParamToString parserUserParamToString = new ParserUserParamToStringImpl();

		String foundedUser = listUser.stream()
				.filter((s) -> ValidatorUserLogin.validateStringLineByLoginAndPassword(s, login, password)).findFirst()
				.orElse(UNDEFINITED_NAME);

		if (foundedUser != UNDEFINITED_NAME) {
			ParserUserParamFromString paramFromString = new ParserUserParamFromStringImpl();
			int id = Integer.valueOf(paramFromString.parseUserFromString(foundedUser)[0]);
			substituteUser.setId(id);

			String newUserString = parserUserParamToString.parseUserParamToTXT(substituteUser);

			listUser = listUser.stream().map(
					(s) -> ValidatorUserLogin.validateStringLineByLoginAndPassword(s, login, password) ? newUserString : s)
					.collect(Collectors.toList());

			DataWriter dataWriter = new DataWriterImp();
			dataWriter.writeAllUsersInTXT(listUser, FILE_SOURCE_USER_NAME);
			
			flag = true;			
		}

		return flag;
	}

	@Override
	public boolean removeUser(String login, String password) throws DAOLibraryException {
		boolean flag = false;
		
		DataReaderImpl dataReaderImpl = new DataReaderImpl();
		List<String> listUser = dataReaderImpl.readAllLegalUser(FILE_SOURCE_USER_NAME);

		String foundedUser = listUser.stream()
				.filter((s) -> ValidatorUserLogin.validateStringLineByLoginAndPassword(s, login, password)).findFirst()
				.orElse(UNDEFINITED_NAME);

		if (foundedUser != UNDEFINITED_NAME) {
			ParserUserParamFromString parserUserParamFromString = new ParserUserParamFromStringImpl();
			
			OUT: for (int i = 0; i < listUser.size(); i++) {
				if (ValidatorUserLogin.validateStringLineByLoginAndPassword(listUser.get(i), login, password)) {
					listUser.remove(i);
					i = i - 1;
					continue OUT;
				}
				String[] usersParam = parserUserParamFromString.parseUserFromString(listUser.get(i));
				usersParam[0] = String.valueOf(i + 1);
				
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(usersParam[0]);
				stringBuilder.append(DELIMITER);
				stringBuilder.append(usersParam[1]);
				stringBuilder.append(DELIMITER);
				stringBuilder.append(usersParam[2]);
				stringBuilder.append(DELIMITER);
				stringBuilder.append(usersParam[3]);
				stringBuilder.append(DELIMITER);
				stringBuilder.append(usersParam[4]);
				stringBuilder.append(DELIMITER);
				stringBuilder.append(usersParam[5]);
				
				listUser.set(i, stringBuilder.toString());			
			}			
			
			DataWriter dataWriter = new DataWriterImp();
			dataWriter.writeAllUsersInTXT(listUser, FILE_SOURCE_USER_NAME);

			flag = true;
		}		
		
		return flag;
	}

}
