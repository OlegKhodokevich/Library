package by.htp.library.dao.reader;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.reader.impl.DataReaderImpl;

public class TestDataReader {
	private static final String FILE_SOURCE_NAME = "data/dataUsers.txt";
	@Test
	public void testDataReader() throws DAOLibraryException {
		DataReaderImpl dataReaderImpl = new DataReaderImpl();
		List<String> actualListUserList = dataReaderImpl.readAllLegalUser(FILE_SOURCE_NAME);
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("1/Khodokevich_Oleg/111aaa/Oleg/admin/parent");
		expectedList.add("2/Khodokevich_Alina/222bbb/Alina/guest/parent");
		expectedList.add("3/Khodokevich_Safina/333ccc/Safina/guest/child");		
		
		Assert.assertEquals(expectedList, actualListUserList);
	}

}
