package qiao;

import java.util.ArrayList;
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
		quicksort(a, 0, a.length);
		return a;
	}

	/**
	 * Quick sort, single pivot
	 * 
	 * @param a
	 * @param start
	 * @param end
	 */
	public static void quicksort(int[] a, int start, int end) {
		if (a == null || a.length < 2 || start >= end) {
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
		quicksort(a, start, i - 1);
		a[i++] = pivot;
		for (Integer n : rightNumbers) {
			a[i++] = n;
		}
		quicksort(a, i - 1, end);
	}

	public static void bubbleSort(int[] a) {
		System.out.println("bubble sort:");
		if (a == null || a.length < 2) {
			return;
		}
		printArray(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
		printArray(a);

	}

	/**
	 * for i = 1:n,
	 * 
	 * swapped = false
	 * 
	 * for j = n:i+1,
	 * 
	 * if a[j] < a[j-1], swap a[j,j-1] swapped = true
	 * 
	 * -> invariant: a[1..i] in final position
	 * 
	 * Properties:
	 * 
	 * Stable
	 * 
	 * O(1) extra space
	 * 
	 * O(n2) comparisons and swaps
	 * 
	 * Adaptive: O(n) when nearly sorted
	 * 
	 * @param a
	 */
	public static void bubbleSort2(int[] a) {
		System.out.println("bubble sort 2:");
		if (a == null || a.length < 2) {
			return;
		}
		printArray(a);
		for (int i = 0; i < a.length; i++) {
			boolean swapped = false;
			for (int j = a.length - 1; j >= i + 1; j--) {
				if (a[j] < a[j - 1]) {
					swap(a, j, j - 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}

		}
		printArray(a);
	}

	/**
	 * for i = 1:n,
	 * 
	 * k = i
	 * 
	 * for j = i+1:n, if a[j] < a[k], k = j
	 * 
	 * -> invariant: a[k] smallest of a[i..n] swap a[i,k]
	 * 
	 * -> invariant: a[1..i] in final position end
	 * 
	 * Properties:
	 * 
	 * Not stable
	 * 
	 * O(1) extra space
	 * 
	 * O(n2) comparisons
	 * 
	 * O(n) swaps
	 * 
	 * Not adaptive
	 * 
	 * Concept:
	 * 
	 * From 1st to last, find the min value, store to the 1st position. 
	 * 
	 * From 2nd to last, find the min value, store to the 2nd position. 
	 * 
	 * From 3rd to last, find the min value, store to the 3rd position. ... 
	 * 
	 * From last-1 to last, find the smaller one, store to the last-1 position. End.
	 * 
	 * Key Point: k=i; // store the current start position
	 * 
	 * if (A[j]<A[k]) {k=j;} // store the index of min value
	 * 
	 * How to Memorize: Select the min value and store to the front.
	 * 
	 * @param a
	 */
	public static void selectionSort(int[] a) {
		System.out.println("secltion sort:");
		if (a == null || a.length < 2) {
			return;
		}
		printArray(a);
		for (int i = 1; i < a.length; i++) {
			int k = i;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[k]) {
					k = j;
				}
			}
			swap(a, i, k);
		}
		printArray(a);
	}

	/**
	 * for i = 2:n,
	 * 
	 * for (k = i; k > 1 and a[k] < a[k-1]; k--)
	 * 
	 * swap a[k,k-1]
	 * 
	 * -> invariant: a[1..i] is sorted
	 * 
	 * end
	 * 
	 * Properties:
	 * 
	 * Stable
	 * 
	 * O(1) extra space
	 * 
	 * O(n2) comparisons and swaps
	 * 
	 * Adaptive: O(n) time when nearly sorted
	 * 
	 * Very low overhead
	 * 
	 * 
	 * @param a
	 */
	public static void insertionSort(int[] a) {
		System.out.println("insertion sort:");
		if (a == null || a.length < 2) {
			return;
		}
		printArray(a);
		for (int i = 1; i < a.length; i++) {
			for (int k = i; k >= 0 && a[k] < a[k - 1]; k--) {
				swap(a, k, k - 1);
			}
		}
		printArray(a);
	}

	/**
	 * The best case for radix sort is that they are taken as consecutive bit
	 * patterns. This will make the keys as short as they can be, still assuming
	 * they are distinct. This makes radix sort O(n·log(n)), but the comparison
	 * based sorts will not be as efficient, as the comparisons will not be
	 * constant time under this assumption. If we instead assume that the keys
	 * are bit patterns of length k·log(n) for a constant k > 1 and base 2 log,
	 * and that they are uniformly random, then radix sort will still be
	 * O(n·log(n)), but so will the comparison based sorts, as the "extra"
	 * length makes even the keys that are consecutive in the sorted result
	 * differ enough that comparisons are constant time on average. If keys are
	 * longer than O(log(n)), but random, then radix sort will be inferior.
	 * 
	 * @param arr
	 * @param maxDigits
	 */
	public static void radixSort(int arr[], int maxDigits) {
		System.out.println("radix sort:");
		printArray(arr);
		int exp = 1;// 10^0;
		for (int i = 0; i < maxDigits; i++) {
			ArrayList<Integer> bucketList[] = new ArrayList[10];
			for (int k = 0; k < 10; k++) {
				bucketList[k] = new ArrayList<Integer>();
			}
			for (int j = 0; j < arr.length; j++) {
				int number = (arr[j] / exp) % 10;
				bucketList[number].add(arr[j]);
			}
			exp *= 10;
			int index = 0;
			for (int k = 0; k < 10; k++) {
				for (int num : bucketList[k]) {
					arr[index] = num;
					index++;
				}
			}
		}
		printArray(arr);
	}

	private static void swap(int[] a, int i, int k) {
		int temp = a[i];
		a[i] = a[k];
		a[k] = temp;
	}

	private static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.println();
	}
}
