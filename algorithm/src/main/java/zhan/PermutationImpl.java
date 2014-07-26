/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zhan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author zhan
 */
public class PermutationImpl<T> {
	private int m_count;
	private int m_index;
	private Set<T[]> m_arrays;
	private T[] m_source;

	public PermutationImpl(T[] a) {
		if (a == null || a.length == 0) {
			throw new IllegalArgumentException();
		}
		m_count = factorial(a.length);
		m_source = a;
	}

	public void printA(final T[] a) {
		StringBuilder b = new StringBuilder();

		for (T e : a) {
			b.append(String.valueOf(e));
		}
		System.out.println(b.toString());
	}

	public void swap(final T[] a, int x, int y) {
		T temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	public Set<T[]> getPermutation() {
		if (m_arrays == null) {
			m_arrays = new HashSet<T[]>();
			permute(0);
		}
		return m_arrays;
	}

	private void permute(int i) {
		final int N = m_source.length - 1;
		if (i == N) {
			m_arrays.add(Arrays.copyOfRange(m_source, 0, m_source.length));
		} else {
			for (int j = i; j <= N; j++) {
				swap(m_source, i, j);
				permute(i + 1);
				swap(m_source, i, j);

			}
		}

	}

	public static void main(final String args[]) {
		// String[] A = {"a", "b", "c", "d"};
		// printA(A);
		// swap(A, 0, 3);
		// printA(A);

		String[] A = { "a", "b", "c" };
		PermutationImpl<String> permutation = new PermutationImpl<String>(A);
		Set<String[]> arrays = permutation.getPermutation();
		for (String[] array : arrays) {
			for (String s : array) {
				System.out.print(s);
				System.out.print(",");
			}
			System.out.println("");
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
