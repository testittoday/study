package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

import qiao.Sorting;

/**
 * 
 * @author liqiao
 * 
 */
public class SortingTest {

	@Test
	public void testAlternate() {
		int[] a = new int[] { 1, 7, 3, 4, 5, 6, 2 };
		int[] alternated = Sorting.alternate(a);
		print(alternated);
		Integer[] b = new Integer[] { 1, 7, 3, 4, 5, 6, 2 };
		Integer[] alternated2 = Sorting.alternate2(b);
		print(alternated2);
		assertFalse(Sorting.isAlternated(b, true));
		assertTrue(Sorting.isAlternated(alternated2, true));

		a = new int[] { 1, 7, 3, 4, 5, 6, 2 };
		Sorting.sort(a, 0, a.length - 1);
		print(a);

		int[] c = { 2, 8, 5, 3, 1, 6, 4 };
		Sorting.sort(c, 0, c.length - 1);
		print(c);

		int[] d = { 1 };
		Sorting.sort(d, 0, d.length - 1);
		print(d);

		int[] e = {};
		Sorting.sort(e, 0, e.length - 1);
		print(e);

	}

	private void print(int[] a) {
		for (int i : a) {
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println(";");
	}

	private void print(Integer[] a) {
		for (Integer i : a) {
			System.out.print(String.valueOf(i));
			System.out.print(",");
		}
		System.out.println(";");
	}

}
