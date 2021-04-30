package by.htp.library.dao.validator;

import org.junit.Assert;
import org.junit.Test;

public class TestValidatorStringUser {
	@Test
	public void TestValidator001() {
		boolean actualResult = ValidatorStringUser.validateStringForCreateUser("1/Khodokevich_Oleg/111aaa/Oleg/admin/parent");
		
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void TestValidator002() {
		boolean actualResult = ValidatorStringUser.validateStringForCreateUser("1/Khodokevich_Oleg/111aaa/Oleg/admin");
		
		Assert.assertFalse(actualResult);
	}

}
