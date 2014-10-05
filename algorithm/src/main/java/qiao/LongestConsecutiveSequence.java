package qiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author liqiao
 * 
 */
public class LongestConsecutiveSequence {

	/**
	 * NlogN complexity, accepted by the Online Judge
	 * 
	 * @param num
	 * @return
	 */
	public static int longestConsecutive(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		if (num.length == 1) {
			return 1;
		}
		Arrays.sort(num);
		int maxCount = 1;
		int count = 1;
		for (int i = 1; i < num.length; i++) {
			if (num[i] - num[i - 1] == 1) {
				count++;
				if (maxCount < count) {
					maxCount = count;
				}
			} else if (num[i] == num[i - 1]) {
				continue;
			} else {
				count = 1;
			}
		}
		return maxCount;
	}

	/**
	 * O(N) complexity
	 * 
	 * Accepted by the Online Judge
	 * 
	 * @param num
	 * @return
	 */
	public int longestConsecutive2(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		if (num.length == 1) {
			return 1;
		}
		Set<Integer> numbers = new HashSet<Integer>();
		for (int n : num) {
			numbers.add(n);
		}
		int result = 1;
		Set<Integer> visited = new HashSet<Integer>();
		for (int number : numbers) {
			int count = 1;
			int n = number;
			if (!visited.contains(n)) {
				while (numbers.contains(++n)) {
					visited.add(n);
					count++;
				}
				if (result < count) {
					result = count;
				}
			}
		}
		return result;
	}
}
