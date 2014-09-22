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

		// [(0,-12),(5,2),(2,5),(0,-5),(1,5),(2,-2),(5,-4),(3,4),(-2,4),(-1,4),(0,-5),(0,-8),(-2,-1),(0,-11),(0,-9)]

		int[][] data = { { 0, -12 }, { 5, 2 }, { 2, 5 }, { 0, -5 }, { 1, 5 },
				{ 2, -2 }, { 5, -4 }, { 3, 4 }, { -2, 4 }, { -1, 4 },
				{ 0, -5 }, { 0, -8 }, { 2, -1 }, { 0, -11 }, { 0, -9 } };
		Point[] points = new Point[data.length];
		for (int i = 0; i < data.length; i++) {
			Point p = new Point(data[i][0], data[i][1]);
			points[i] = p;
		}
		System.out.println(Searching.maxPoints(points));
	}

	@Test
	/**
	 * 
	 */
	public void testIsMatch() {
		assertFalse(Searching.isMatch("a", "b.."));
		assertTrue(Searching.isMatch("", ""));
		assertTrue(Searching.isMatch("baccbbcbcacacbbc", "c*.*b*c*ba*b*b*.a*"));
		assertTrue(Searching.isMatch("", ".*"));
		assertFalse(Searching.isMatch("aa", "a"));
		assertTrue(Searching.isMatch("aa", "aa"));
		assertFalse(Searching.isMatch("aaa", "a"));
		assertTrue(Searching.isMatch("aa", "a*"));
		assertTrue(Searching.isMatch("aaaaa", "a*"));
		assertTrue(Searching.isMatch("aaa", ".*"));
		assertTrue(Searching.isMatch("abc", ".*"));
		assertTrue(Searching.isMatch("aab", "c*a*b*"));
		assertFalse(Searching.isMatch("abcd", "d*"));
		assertTrue(Searching.isMatch("aaa", "a*a"));
		assertTrue(Searching.isMatch("aaa", "ab*ac*a"));
		assertTrue(Searching.isMatch("aaa", "ab*a*c*a"));
		assertTrue(Searching.isMatch("aaca", "ab*a*c*a"));
		assertTrue(Searching.isMatch("a", "."));
		assertTrue(Searching.isMatch("a", "ab*"));
		assertTrue(Searching.isMatch("bbbba", ".*a*a"));
		assertFalse(Searching.isMatch("a", ".*..a*"));
		assertTrue(Searching.isMatch("ab", ".*.."));
		assertTrue(Searching.isMatch("abbbc", "ab*c"));
		assertTrue(Searching.isMatch("ac", "ab*c"));
		assertTrue(Searching.isMatch("abbc", "ab*bbc"));
		assertTrue(Searching.isMatch("abcbcd", "a.*c.*.*d"));
		assertFalse(Searching.isMatch("ab", ".*c"));
		assertFalse(Searching.isMatch("aaa", "ab*a"));
		assertFalse(Searching.isMatch("aaba", "ab*a*c*a"));
	}
}
