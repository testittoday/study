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
}
