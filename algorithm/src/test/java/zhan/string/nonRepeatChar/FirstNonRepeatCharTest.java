package zhan.string.nonRepeatChar;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstNonRepeatCharTest {

	@Test
	public void test() {
		String testString = "aaaacbdccc";
		char result;
		assertTrue('b' == FirstNonRepeatChar.findFirstNonRepeatChar(testString));
		testString = " abc";
		result = FirstNonRepeatChar.findFirstNonRepeatChar(testString);
		assertTrue("result: " + result, ' ' == result);
		testString = "   abc";
		result = FirstNonRepeatChar.findFirstNonRepeatChar(testString);
		assertTrue("result: " + result, 'a' == result);

		// should '0' be returned for null or empty input?
		testString = null;
		result = FirstNonRepeatChar.findFirstNonRepeatChar(testString);
		assertTrue("result: " + result, '0' == result);
		testString = "";
		result = FirstNonRepeatChar.findFirstNonRepeatChar(testString);
		assertTrue("result: " + result, '0' == result);

	}
}
