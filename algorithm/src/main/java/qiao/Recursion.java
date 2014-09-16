package qiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursion {

	/**
	 * Problem Description:
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * 
	 * For example, given numRows = 5, Return
	 * 
	 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
	 * 
	 * Accepted by the Online Judge
	 * 
	 */
	public List<List<Integer>> generate(int numRows) {
		if (numRows < 0) {
			throw new IllegalArgumentException();
		}
		if (numRows == 0) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 1; i <= numRows; i++) {
			List<Integer> aRow = new ArrayList<Integer>();
			int[] a = getArray(i);
			for (int j : a) {
				aRow.add(Integer.valueOf(j));
			}
			result.add(aRow);
		}
		return result;
	}

	public int[] getArray(int n) {
		if (n == 1) {
			return new int[] { 1 };
		} else if (n == 2) {
			return new int[] { 1, 1 };
		} else {
			int[] a = new int[n];
			a[0] = 1;
			a[n - 1] = 1;
			int[] b = getArray(n - 1);
			for (int i = 0; i < b.length - 1; i++) {
				a[i + 1] = b[i] + b[i + 1];
			}
			return a;
		}
	}
}
