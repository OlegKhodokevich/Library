package by.htp.library.dao.parser;

import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOLibraryException;

public interface ParserUserParamToString {
	public String parseUserParamToTXT(User user) throws DAOLibraryException;

}
