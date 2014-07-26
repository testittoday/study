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
public class Permutation<T> {

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

	public Set<T[]> getPermutation(T[] source) {
		Set<T[]> result = new HashSet<T[]>();
		permute(0, 0, source, result);
		return result;
	}

	private void permute(int i, int index, T[] source, Set<T[]> result) {
		final int N = source.length - 1;
		if (i == N) {
			result.add(Arrays.copyOfRange(source, 0, source.length));
		} else {
			for (int j = i; j <= N; j++) {
				swap(source, i, j);
				permute(i + 1, index++, source, result);
				swap(source, i, j);

			}
		}

	}

	public static void main(final String args[]) {
		// String[] A = {"a", "b", "c", "d"};
		// printA(A);
		// swap(A, 0, 3);
		// printA(A);

		String[] A = { "a", "b", "c" };
		Permutation<String> permutation = new Permutation<String>();
		Set<String[]> arrays = permutation.getPermutation(A);
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
