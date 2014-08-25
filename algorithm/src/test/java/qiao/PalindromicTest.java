package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromicTest {

	@Test
	public void test() {
		assertFalse(PalindromicProblems.isPalindrome(-1));
		assertTrue(PalindromicProblems.isPalindrome(3));
		assertTrue(PalindromicProblems.isPalindrome(33));
		assertTrue(PalindromicProblems.isPalindrome(323));
		assertTrue(PalindromicProblems.isPalindrome(3223));
		assertTrue(PalindromicProblems.isPalindrome(121));
		assertFalse(PalindromicProblems.isPalindrome(123));
		assertTrue(PalindromicProblems.isPalindrome(12321));
		assertFalse(PalindromicProblems.isPalindrome(123211));
		assertFalse("Max value: " + Integer.MAX_VALUE,
				PalindromicProblems.isPalindrome(2147483647));
		assertTrue(PalindromicProblems.isPalindrome(1111111111));
		assertFalse(PalindromicProblems.isPalindrome(10000021));
		assertTrue(PalindromicProblems.isPalindrome(1000110001));
		assertTrue(PalindromicProblems.isPalindrome(1000330001));
		assertTrue(PalindromicProblems.isPalindrome(100020001));
		assertFalse(PalindromicProblems.isPalindrome(1000200001));
	}

}
