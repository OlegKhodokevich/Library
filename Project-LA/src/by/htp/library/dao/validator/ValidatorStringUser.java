package by.htp.library.dao.validator;

public class ValidatorStringUser {
	private static final String USER_REG_EXP = "\\d{1,}\\/\\w+\\/\\w{6,}\\/\\w+\\/\\w+\\/\\w+"; // 1/Khodokevich_Oleg/111aaa/Oleg/admin/parent

	public static boolean validateStringForCreateUser(String line) {
		if (line.matches(USER_REG_EXP)) {
			return true;
		}

		return false;
	}

}
