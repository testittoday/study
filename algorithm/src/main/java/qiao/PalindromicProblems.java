package qiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Determine whether an integer is a palindrome.
 * 
 * How to do this without extra space?
 * 
 * @author liqiao
 * 
 */

public class PalindromicProblems {

	public static boolean isPalindrome(int n) {
		if (n < 10 && n >= 0) {
			return true;
		}
		if (n < 0) {
			return false;
		}
		List<Integer> digits = new ArrayList<Integer>();
		while (n >= 10) {
			digits.add(n % 10);
			n = n / 10;
		}
		digits.add(n);
		return isPalindrome(digits);
	}

	private static boolean isPalindrome(List<Integer> digits) {
		if (digits == null || digits.size() < 2) {
			return true;
		}
		boolean evenLength = digits.size() % 2 == 0;
		int lowStart = digits.size() / 2;
		if (evenLength) {
			lowStart = lowStart - 1;
		}
		for (int i = lowStart, j = digits.size() / 2; i >= 0
				&& j < digits.size(); i--, j++) {
			if (digits.get(i).intValue() != digits.get(j).intValue()) {
				return false;
			}
		}
		return true;
	}

}
