package qiao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayMiningTest {

	@Test
	public void testMinimumTotal() {
		int[][] input = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		for (int[] row : input) {
			List<Integer> aRow = new ArrayList<Integer>();
			for (int i : row) {
				aRow.add(Integer.valueOf(i));
			}
			triangle.add(aRow);
		}
		int minSum = ArrayMining.minimumTotal(triangle);
		System.out.println(minSum);
	}

}
