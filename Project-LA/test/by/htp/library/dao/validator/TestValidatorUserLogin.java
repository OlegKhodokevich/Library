package by.htp.library.dao.validator;

import org.junit.Assert;
import org.junit.Test;

public class TestValidatorUserLogin {
	
	@Test
	public void TestValidatorUserLogin001() {
		boolean actualResult = ValidatorUserLogin.validateStringLineByLoginAndPassword("1/Khodokevich_Oleg/111aaa/Oleg/admin/parent", "Khodokevich_Oleg", "111aaa");
				Assert.assertTrue(actualResult);
	}
	
	@Test
	public void TestValidatorUserLogin002() {
		boolean actualResult = ValidatorUserLogin.validateStringLineByLoginAndPassword("1/Khodokevich_Oleg/111aaa/Oleg/admin/parent", "Khodokevich_Oleg1", "111aaa");
				Assert.assertFalse(actualResult);
	}
}
