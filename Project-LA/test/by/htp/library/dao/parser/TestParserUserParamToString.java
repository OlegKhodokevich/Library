package by.htp.library.dao.parser;

import org.junit.Assert;
import org.junit.Test;

import by.htp.library.bean.AgeTypeUser;
import by.htp.library.bean.StatusUser;
import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.impl.ParserUserParamToStringImpl;

public class TestParserUserParamToString {
	
	@Test
	public void testParserUserParamToString( ) throws DAOLibraryException {
		ParserUserParamToString paramToString = new ParserUserParamToStringImpl();
		
		User user = new User(3, "Khodokevich_Safina", "333ccc", "Safina", StatusUser.GUEST, AgeTypeUser.CHILD);
		String actualUserParamString = paramToString.parseUserParamToTXT(user);
		String expectedUserParamString = "3/Khodokevich_Safina/333ccc/Safina/GUEST/CHILD";
		
		Assert.assertEquals(expectedUserParamString, actualUserParamString);
	}

}
