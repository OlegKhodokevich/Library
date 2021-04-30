package by.htp.library.dao.validator;

public class ValidatorUserLogin {
	public static boolean validateStringLineByLoginAndPassword(String line, String login, String password) {
		boolean result = false;
		if (line.contains(login) && line.contains(password)) {
			result = true;
		}

		return result;
	}

}
