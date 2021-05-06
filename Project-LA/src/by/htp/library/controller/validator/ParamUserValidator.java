package by.htp.library.controller.validator;

public class ParamUserValidator {

	private static final String LOGIN_PASSWORD_REG_EXP = "\\w+\\s\\w{6,}";;

	public static boolean validateDataForSignIn(String request) {
		boolean result = false;

		if (request.matches(LOGIN_PASSWORD_REG_EXP)) {
			result = true;
		}

		return result;
	}

}
