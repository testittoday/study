package qiao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import zhan.Permutation;

/**
 * 
 * @author liqiao
 * 
 */
public class Sorting {

	/**
	 * returning an alternate array created from the given one that contains
	 * only unique numbers
	 * 
	 * @param original
	 * @return
	 */
	public static int[] alternate(int[] original) {
		if (original != null && original.length > 0) {
			int[] target = new int[original.length];
			Arrays.sort(original);
			alternate(target, original, 0);
			return target;
		} else {
			return new int[0];
		}
	}

	public static Integer[] alternate2(Integer[] original) {
		Permutation<Integer> permutation = new Permutation<Integer>();
		Set<Integer[]> permutations = permutation.getPermutation(original);
		for (Integer[] a : permutations) {
			if (isAlternated(a, true)) {
				return a;
			}
		}
		return new Integer[0];
	}

	private static void alternate(int[] target, int[] source, int index) {
		if (source == null || source.length == 0) {
			return;
		}
		if (source.length == 1) {
			target[target.length - 1] = source[0];
		} else {
			if ((index % 2) == 0) {
				target[index] = source[0];
				int[] newSource = Arrays.copyOfRange(source, 1, source.length);
				alternate(target, newSource, index + 1);
			} else {
				target[index] = source[1];
				int[] newSource = new int[source.length - 1];
				newSource[0] = source[0];
				if (source.length > 2) {
					for (int i = 2; i < source.length; i++) {
						newSource[i - 1] = source[i];
					}
				}
				alternate(target, newSource, index + 1);
			}
		}
	}

	public static boolean isAlternated(Integer[] a, boolean greatGreater) {
		boolean isAlternated = true;
		for (int i = 0, j = 1; i < a.length - 2 && j < a.length - 1; i++, j++) {
			if (greatGreater) {
				isAlternated &= a[j] > a[i];
			} else {
				isAlternated &= a[j] < a[i];
			}
			greatGreater = !greatGreater;
			if (!isAlternated) {
				break;
			}
		}
		return isAlternated;
	}

	public static int[] sort(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		if (a.length == 1) {
			return a;
		}
		return a;
	}

	public static void sort(int[] a, int start, int end) {
		if (start >= end || a.length == 1) {
			return;
		}
		Set<Integer> leftNumbers = new HashSet<Integer>();
		Set<Integer> rightNumbers = new HashSet<Integer>();
		int pivot = a[start];
		for (int i = start + 1; i <= end; i++) {
			if (a[i] <= pivot) {
				leftNumbers.add(a[i]);
			} else if (a[i] > pivot) {
				rightNumbers.add(a[i]);
			}
		}
		int i = start;
		for (Integer n : leftNumbers) {
			a[i++] = n;
		}
		sort(a, start, i - 1);
		a[i++] = pivot;
		for (Integer n : rightNumbers) {
			a[i++] = n;
		}
		sort(a, i - 1, end);
	}
}
