package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidNumberTest {

	@Test
	public void test() {
		assertTrue(ValidNumber.isNumber("2e0"));
		assertTrue(ValidNumber.isNumber("-1."));
		assertFalse(ValidNumber.isNumber("1 4"));
		assertTrue(ValidNumber.isNumber("46.e3"));
		assertFalse(ValidNumber.isNumber("671.l"));
		assertTrue(ValidNumber.isNumber(".2e81"));
		assertTrue(ValidNumber.isNumber("-.3e6"));
		assertTrue(ValidNumber.isNumber("-070991.58"));
		assertTrue(ValidNumber.isNumber(" 005047e+6"));
		assertTrue(ValidNumber.isNumber("32.e-80123"));
		assertTrue(ValidNumber.isNumber("-788f"));
	}

}
