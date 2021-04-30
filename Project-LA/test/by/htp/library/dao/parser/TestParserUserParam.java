package by.htp.library.dao.parser;

import org.junit.Assert;
import org.junit.Test;

import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.impl.ParserUserParamFromStringImpl;

public class TestParserUserParam {
	
	@Test
	public void testParser001() throws DAOLibraryException {
		ParserUserParamFromStringImpl parserUserParamFromString = new ParserUserParamFromStringImpl();
		String[] actualParamUser = parserUserParamFromString.parseUserFromString("3/Khodokevich_Safina/333ccc/Safina/guest/child");
		String[] expectedParamUser = new String[] {"3", "Khodokevich_Safina", "333ccc", "Safina", "guest", "child"}; 
		
		Assert.assertArrayEquals(expectedParamUser, actualParamUser);
	}

}
