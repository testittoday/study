package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchingTest {

	@Test
	public void testGetMajorityElement() {
		int[] a = new int[] { 1, 1, 2, 2, 1 };
		Integer majorityElement = Searching.getMajorityElement(a);
		assertTrue(majorityElement != null && majorityElement == 1);
		a = new int[] { 1, 1, 2, 2 };
		majorityElement = Searching.getMajorityElement(a);
		assertTrue(majorityElement == null);
		a = new int[] { 1, 2, 3 };
		majorityElement = Searching.getMajorityElement(a);
		assertTrue(majorityElement == null);
		a = new int[] { 1, 2, 3, 4, 5, 2, 1, 5, 2 };
		majorityElement = Searching.getMajorityElement(a);
		assertTrue(majorityElement == null);
		a = new int[] { 1, 2, 2, 3 };
		majorityElement = Searching.getMajorityElement(a);
		assertTrue(majorityElement == null);
		a = new int[] { 1, 2, 3, 4, 5, 2, 1, 5, 2, 3, 3, 3, 3, 3, 3, 3, 3 };
		majorityElement = Searching.getMajorityElement(a);
		assertTrue(majorityElement != null && majorityElement == 3);
	}

	@Test
	/**
	 * isMatch(“aa”,”a”) → false
	isMatch(“aa”,”aa”) → true
	isMatch(“aaa”,”aa”) → false
	isMatch(“aa”, “a*”) → true
	isMatch(“aa”, “.*”) → true
	isMatch(“ab”, “.*”) → true
	isMatch(“aab”, “c*a*b”) → true
	 */
	public void testIsMatch() {
//		assertFalse(Searching.isMatch("aa", "a"));
//		assertTrue(Searching.isMatch("aa", "aa"));
//		assertFalse(Searching.isMatch("aaa", "a"));
//		assertTrue(Searching.isMatch("aa", "a*"));
//		assertTrue(Searching.isMatch("aaaaa", "a*"));
//		assertTrue(Searching.isMatch("aaa", ".*"));
//		assertTrue(Searching.isMatch("abc", ".*"));
//		assertTrue(Searching.isMatch("aab", "c*a*b*"));
//		assertFalse(Searching.isMatch("abcd", "d*"));
//		assertTrue(Searching.isMatch("aaa", "a*a"));
//		assertTrue(Searching.isMatch("aaa", "ab*ac*a"));
//		assertTrue(Searching.isMatch("aaa", "ab*a*c*a"));
//		assertTrue(Searching.isMatch("aaca", "ab*a*c*a"));
//		assertTrue(Searching.isMatch("a", "."));
//		assertTrue(Searching.isMatch("a", "ab*"));
//		assertTrue(Searching.isMatch("bbbba", ".*a*a"));
//		assertFalse(Searching.isMatch("a", ".*..a*"));
//		assertTrue(Searching.isMatch("ab", ".*.."));
//		assertTrue(Searching.isMatch("abbbc", "ab*c"));
//		assertTrue(Searching.isMatch("ac", "ab*c"));
//		assertTrue(Searching.isMatch("abbc", "ab*bbc"));
//		assertTrue(Searching.isMatch("abcbcd", "a.*c.*.*d"));
		assertFalse(Searching.isMatch("ab", ".*c"));
		assertFalse(Searching.isMatch("aaa", "ab*a"));
		assertFalse(Searching.isMatch("aaba", "ab*a*c*a"));
	}
}
