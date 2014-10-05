package qiao;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WildcardMatchingTest {

	@Test
	public void test() {
		assertFalse(WildcardMatching.isMatch("b", "*a*"));
		assertTrue(WildcardMatching.isMatch("ab", "*?*?*"));
		assertTrue(WildcardMatching.isMatch("aa", "*aa"));
		assertTrue(WildcardMatching.isMatch("ab", "*ab"));
		assertTrue(WildcardMatching.isMatch("aa", "*a"));
		assertTrue(WildcardMatching.isMatch("aac", "*ac"));
		assertTrue(WildcardMatching.isMatch("afuiojeruac", "*ac"));
		assertTrue(WildcardMatching.isMatch("aac", "*c"));
		assertTrue(WildcardMatching.isMatch("aac", "*a*c"));
		assertTrue(WildcardMatching.isMatch("abc", "*a*c"));
		assertTrue(WildcardMatching.isMatch("abbbc", "*a*c"));
		assertFalse(WildcardMatching.isMatch("aac", "*bc"));
		assertFalse(WildcardMatching.isMatch("ab", "*a"));
		assertFalse(WildcardMatching.isMatch("aa", "a"));
		assertTrue(WildcardMatching.isMatch("aa", "aa"));
		assertFalse(WildcardMatching.isMatch("aaa", "aa"));
		assertTrue(WildcardMatching.isMatch("aa", "*"));
		assertTrue(WildcardMatching.isMatch("aa", "a*"));
		assertTrue(WildcardMatching.isMatch("ab", "?*"));
		assertFalse(WildcardMatching.isMatch("aab", "c*a*b"));
		assertFalse(WildcardMatching.isMatch("b", "?*?"));
		assertFalse(WildcardMatching.isMatch("b", "*?*?"));
		assertTrue(WildcardMatching.isMatch("c", "*?*"));
	}
}
