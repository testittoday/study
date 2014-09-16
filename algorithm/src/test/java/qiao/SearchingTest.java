package qiao;

import static org.junit.Assert.assertTrue;

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
}
