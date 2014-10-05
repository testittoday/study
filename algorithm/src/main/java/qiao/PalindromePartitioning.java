package qiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author liqiao
 * 
 *         Given a string s, partition s such that every substring of the
 *         partition is a palindrome.
 * 
 *         Return all possible palindrome partitioning of s.
 * 
 *         For example, given s = "aab", Return
 * 
 *         [ ["aa","b"], ["a","a","b"] ]
 * 
 */
public class PalindromePartitioning {

	/**
	 * Accepted by the Online Judge
	 * 
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
		if (s == null || s.length() == 0) {
			return Collections.emptyList();
		}
		List<List<String>> result = new ArrayList<List<String>>();
		if (s.length() == 1) {
			List<String> l = new ArrayList<String>();
			l.add(s);
			result.add(l);
		} else {
			Stack<String> p = new Stack<String>();
			char[] letters = s.toCharArray();
			partition(letters, 0, result, p);
		}
		return result;
	}

	private static void partition(char[] letters, int start,
			List<List<String>> result, Stack<String> p) {
		if (start >= letters.length - 1) {
			List<String> a = new ArrayList<String>();
			a.addAll(p);
			if (start == letters.length - 1) {
				a.add(String.valueOf(letters[start]));
			}
			result.add(a);
		} else {
			for (int i = start; i < letters.length; i++) {
				if (isPalindrom(letters, start, i)) {
					p.push(new String(Arrays.copyOfRange(letters, start, i + 1)));
					partition(letters, i + 1, result, p);
					p.pop();
				}
			}
		}
	}

	private static boolean isPalindrom(char[] letters, int start, int end) {
		while (start < end) {
			if (letters[start++] != letters[end--]) {
				return false;
			}
		}
		return true;
	}

}
