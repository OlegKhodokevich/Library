package by.htp.library.dao.validator;

public class ValidatorBookByParam {
	public static boolean validateStringBookByNameAndAutor(String line, String nameBook, String autor) {
		boolean result = false;
		if (line.contains(nameBook) && line.contains(autor)) {
			result = true;
		}

		return result;
	}

}
