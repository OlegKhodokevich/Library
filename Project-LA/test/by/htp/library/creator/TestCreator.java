package by.htp.library.creator;

import org.junit.Assert;
import org.junit.Test;

import by.htp.library.bean.AgeTypeUser;
import by.htp.library.bean.StatusUser;
import by.htp.library.bean.User;
import by.htp.library.bean.creator.impl.UserCreatorImpl;
import by.htp.library.dao.exception.DAOLibraryException;

public class TestCreator {

	@Test
	public void testCreator001() throws DAOLibraryException {
		UserCreatorImpl userCreator = new UserCreatorImpl();
		User user = userCreator.createUserByString("3/Khodokevich_Safina/333ccc/Safina/guest/child");
		User expectedUser = new User(3, "Khodokevich_Safina", "333ccc", "Safina", StatusUser.GUEST, AgeTypeUser.CHILD);

		Assert.assertEquals(expectedUser, user);
	}

	@Test
	public void testCreator002() throws DAOLibraryException {
		UserCreatorImpl userCreator = new UserCreatorImpl();
		User user = userCreator.createUserByString("3/Khodokevich_Safina/333ccc/Safina/guest2/child2");
		User expectedUser = new User(3, "Khodokevich_Safina", "333ccc", "Safina", StatusUser.UNDEFINITE,
				AgeTypeUser.UNDEFINITE);

		Assert.assertEquals(expectedUser, user);
	}

}
