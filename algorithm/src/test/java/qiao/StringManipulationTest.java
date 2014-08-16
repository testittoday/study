package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringManipulationTest {

	@Test
	public void test() {
		assertTrue(StringManipulation.isPalindrome(232));
		assertTrue(StringManipulation.isPalindrome(2));
		assertFalse(StringManipulation.isPalindrome(31));
		assertTrue(StringManipulation.isPalindrome(333));
		assertTrue(StringManipulation.isPalindrome(3223));
		assertFalse(StringManipulation.isPalindrome(-1));

		assertTrue(StringManipulation.isPalindromic("3223".toCharArray(), 0, 3));
		assertTrue(StringManipulation
				.isPalindromic("32123".toCharArray(), 0, 4));
		assertTrue(StringManipulation.isPalindromic("321234".toCharArray(), 0,
				4));
		assertFalse(StringManipulation.isPalindromic("321234".toCharArray(), 0,
				5));

		System.out.println("largest:"
				+ StringManipulation.findLargestPalindromicStr(
						"3212343210000000".toCharArray(), 0));
	}

}
