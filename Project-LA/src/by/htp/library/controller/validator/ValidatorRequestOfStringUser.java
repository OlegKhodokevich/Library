package by.htp.library.controller.validator;

public class ValidatorRequestOfStringUser {
	private static final String USER_REG_EXP = "\\w+\\s\\w{6,}\\s\\w+\\s\\w+\\s\\w+"; // 1/Khodokevich_Oleg/111aaa/Oleg/admin/parent
	private static final String LINE_FOR_EDITE_REG_EXP = "\\w+\\s\\w{6,}\\s\\w+\\s\\w{6,}\\s\\w+\\s\\w{6,}\\s\\w+\\s\\w+\\s\\w+";
	private static final String LINE_FOR_GET_ALL_USERS = "\\w+\\s\\w{6,}"; 
	private static final String LINE_FOR_REMOVE_USER = "\\w+\\s\\w{6,}\\s\\w+\\s\\w{6,}"; 
	
	public static boolean validateStringForCreateUser(String line) {
		if (line.matches(USER_REG_EXP)) {
			return true;
		}

		return false;
	}
	
	public static boolean validateStringForEditeUser(String line) {
		if (line.matches(LINE_FOR_EDITE_REG_EXP)) {
			return true;
		}

		return false;
	}
	
	public static boolean validateStringForGetAllUser(String line) {
		if (line.matches(LINE_FOR_GET_ALL_USERS)) {
			return true;
		}

		return false;
	}
	
	public static boolean validateStringForRemoveUser(String line) {
		if (line.matches(LINE_FOR_REMOVE_USER)) {
			return true;
		}

		return false;
	}

}
