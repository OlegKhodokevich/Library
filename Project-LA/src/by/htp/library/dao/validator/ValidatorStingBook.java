package by.htp.library.dao.validator;

public class ValidatorStingBook {
	private static final String BOOK_REG_EXP = "\\d+\\/\\w+\\/\\w+\\/\\w+\\/\\d+\\/\\w+\\/\\w+\\/\\w+\\/\\w+"; //  1/Tatiana Polyakova/Mansion with access to the astral plane/detective/2021/paper/all/home

	public static boolean validateStringBook(String line) {
		if (line.matches(BOOK_REG_EXP)) {
			return true;
		}

		return false;
	}
}
