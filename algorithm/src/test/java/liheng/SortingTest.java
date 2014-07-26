package liheng;

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
		for (int i = 0; i < alternated.length; i++) {
			System.out.print(alternated[i]);
			System.out.print(" , ");
		}
		System.out.println("");
		Integer[] b = new Integer[] { 1, 7, 3, 4, 5, 6, 2 };
		Integer[] alternated2 = Sorting.alternate2(b);
		for (int i = 0; i < alternated2.length; i++) {
			System.out.print(alternated[i]);
			System.out.print(" , ");
		}
		assertFalse(Sorting.isAlternated(b, true));
		assertTrue(Sorting.isAlternated(alternated2, true));
	}

}
