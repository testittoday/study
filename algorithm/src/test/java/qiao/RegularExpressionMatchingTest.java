package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegularExpressionMatchingTest {

	@Test
	public void test() {
		assertFalse(RegularExpressionMatching.isMatch("a", "b.."));
		assertTrue(RegularExpressionMatching.isMatch("", ""));
		assertTrue(RegularExpressionMatching.isMatch("baccbbcbcacacbbc",
				"c*.*b*c*ba*b*b*.a*"));
		assertTrue(RegularExpressionMatching.isMatch("", ".*"));
		assertFalse(RegularExpressionMatching.isMatch("aa", "a"));
		assertTrue(RegularExpressionMatching.isMatch("aa", "aa"));
		assertFalse(RegularExpressionMatching.isMatch("aaa", "a"));
		assertTrue(RegularExpressionMatching.isMatch("aa", "a*"));
		assertTrue(RegularExpressionMatching.isMatch("aaaaa", "a*"));
		assertTrue(RegularExpressionMatching.isMatch("aaa", ".*"));
		assertTrue(RegularExpressionMatching.isMatch("abc", ".*"));
		assertTrue(RegularExpressionMatching.isMatch("aab", "c*a*b*"));
		assertFalse(RegularExpressionMatching.isMatch("abcd", "d*"));
		assertTrue(RegularExpressionMatching.isMatch("aaa", "a*a"));
		assertTrue(RegularExpressionMatching.isMatch("aaa", "ab*ac*a"));
		assertTrue(RegularExpressionMatching.isMatch("aaa", "ab*a*c*a"));
		assertTrue(RegularExpressionMatching.isMatch("aaca", "ab*a*c*a"));
		assertTrue(RegularExpressionMatching.isMatch("a", "."));
		assertTrue(RegularExpressionMatching.isMatch("a", "ab*"));
		assertTrue(RegularExpressionMatching.isMatch("bbbba", ".*a*a"));
		assertFalse(RegularExpressionMatching.isMatch("a", ".*..a*"));
		assertTrue(RegularExpressionMatching.isMatch("ab", ".*.."));
		assertTrue(RegularExpressionMatching.isMatch("abbbc", "ab*c"));
		assertTrue(RegularExpressionMatching.isMatch("ac", "ab*c"));
		assertTrue(RegularExpressionMatching.isMatch("abbc", "ab*bbc"));
		assertTrue(RegularExpressionMatching.isMatch("abcbcd", "a.*c.*.*d"));
		assertFalse(RegularExpressionMatching.isMatch("ab", ".*c"));
		assertFalse(RegularExpressionMatching.isMatch("aaa", "ab*a"));
		assertFalse(RegularExpressionMatching.isMatch("aaba", "ab*a*c*a"));
	}

}
