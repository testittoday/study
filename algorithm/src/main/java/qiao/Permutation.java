package qiao;

import java.util.Arrays;

/**
 * 
 * @author liqiao
 * 
 */
public class Permutation {
	private int m_count;
	private int m_index;
	private int[][] m_arrays;
	private int[] m_source;

	public Permutation(int[] a) {
		if (a == null || a.length == 0) {
			throw new IllegalArgumentException();
		}
		m_count = factorial(a.length);
		m_arrays = new int[m_count][a.length];
		m_source = a;
	}

	/**
	 * returning all permutations of the given array that contains unique
	 * numbers
	 * 
	 * @param a
	 * @return
	 */
	public int[][] getPermutations() {
		for (int i = 0; i < m_source.length; i++) {
			permutate(i, 0, new int[m_source.length]);
		}
		return m_arrays;
	}

	/**
	 * Assuming the
	 * 
	 * @param restul
	 * @param source
	 * @param index
	 */
	private void permutate(int sourceInd, int targetInd, int[] target) {
		target[targetInd] = m_source[sourceInd];
		if (targetInd >= m_source.length - 1) {
			for (int i : target) {
				System.out.print(i);
				System.out.print("->");
			}
			System.out.print("\n");
			m_arrays[m_index++] = target;
		} else {
			targetInd++;
			if(sourceInd==m_source.length-1 && targetInd<m_source.length){
				sourceInd--;
			}
			for (int i = sourceInd + 1; i < m_source.length; i++) {
				permutate(i, targetInd, Arrays.copyOf(target, target.length));
			}
		}
	}

	public static int factorial(int i) {
		if (i < 0) {
			throw new IllegalArgumentException("postive only");
		} else if (i == 0 || i == 1) {
			return 1;
		} else {
			return i * factorial(i - 1);
		}

	}
}
