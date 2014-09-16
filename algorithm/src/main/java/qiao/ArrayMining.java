package qiao;

import java.util.Arrays;
import java.util.List;

public class ArrayMining {

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to buy one share of the stock and sell one
	 * share of the stock, design an algorithm to find the best times to buy and
	 * sell.
	 */
	public static int findMaxDiff(int[] prices) {
		if (prices == null || prices.length == 1) {
			throw new IllegalArgumentException();
		}

		int minInd = 0;
		int maxInd = 0;
		int maxDiff = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < prices[minInd]) {
				minInd = i;
			}
			if (maxDiff < (prices[i] - prices[minInd])) {
				maxDiff = prices[i] - prices[minInd];
				maxInd = i;
			}
		}
		System.out.println("best time to buy: " + minInd);
		System.out.println("best time to sell: " + maxInd);
		System.out.println("maximum gain: " + maxDiff);
		return maxDiff;
	}

	/**
	 * Problem Description: Given a triangle, find the minimum path sum from top
	 * to bottom. Each step you may move to adjacent numbers on the row below.
	 * 
	 * For example, given the following triangle [ [2], [3,4], [6,5,7],
	 * [4,1,8,3] ] The minimum path sum from top to bottom is 11 (i.e., 2 + 3 +
	 * 5 + 1 = 11).
	 * 
	 * Note: Bonus point if you are able to do this using only O(n) extra space,
	 * where n is the total number of rows in the triangle.
	 * 
	 * Not accepted. But it seems that it is a bug in the Online Judge.
	 * 
	 * @param triangle
	 * @return
	 */
	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int minSum = 0;
		int index = 0;
		for (List<Integer> row : triangle) {
			index = findMinIndex(row, index);
			minSum += row.get(index);
		}
		return minSum;
	}

	private static int findMinIndex(List<Integer> numbers, int index) {
		int right = index + 1;
		if (right >= numbers.size()) {
			right = numbers.size() - 1;
		}
		if (numbers.get(index) < numbers.get(right)) {
			return index;
		} else {
			return right;
		}
	}

	/**
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 * @param A
	 * @param B
	 * @return
	 */

	public double findMedianSortedArrays(int A[], int B[]) {
		if (A == null || A.length == 0) {
			if (B != null && B.length > 0) {
				if (B.length % 2 == 1) {
					return B[B.length / 2];
				}
			}
		}
		int medianInd = (A.length + B.length) / 2;
		boolean oddLength = (A.length + B.length) % 2 == 1;
		int previous = A[0];
		for (int i = 1, j = 0; i < A.length || j < B.length;) {
			if (previous < B[j]) {
				if (i + j == medianInd) {
					if (oddLength) {
						return A[i];
					} else {
						return (previous + A[i]) / 2;
					}
				}
				previous = A[i];
				if (i < A.length - 1) {
					i++;
				}
			} else {
				if (i + j == medianInd) {
					if (oddLength) {
						return B[j];
					} else {
						return (previous + B[j]) / 2;
					}
				}
				previous = B[j];
				j++;
			}
		}
	}

	/**
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	public static int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			throw new IllegalArgumentException();
		}
		if (A.length == 1) {
			return A[0];
		}
		Arrays.sort(A);
		for (int i = 0; i < A.length; i = i + 2) {
			if (i + 1 < A.length && A[i] != A[i + 1]) {
				return A[i];
			}
		}
		return A[A.length - 1];
	}
}
