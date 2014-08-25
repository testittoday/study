package qiao;

/**
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
		int lastDigit = n % 10;
		int fold = 0;
		int firstDigit = n;
		while (firstDigit >= 10) {
			firstDigit = firstDigit / 10;
			fold++;
		}
		if (lastDigit == firstDigit) {
			if (n < 100) {
				return true;
			} else {
				n = trim(n, firstDigit, fold);
				return isPalindrome(n);
			}
		}
		return false;
	}

	public static int trim(int n, int firstDigit, int fold) {
		if (n < 100 && n >= 0) {
			return n;
		}
		int originalFold = fold;
		while (fold > 0) {
			firstDigit *= 10;
			fold--;
		}
		n -= firstDigit;
		int newFold = 0;
		int newN = n;
		while (newN >= 10) {
			newN = newN / 10;
			newFold++;
		}
		int leftZeroCount = originalFold - 2 - newFold;
		int rightZeroCount = 0;
		newN = n;
		while (newN % 10 == 0) {
			newN = newN / 10;
			rightZeroCount++;
		}
		if (leftZeroCount == rightZeroCount) {
			return n;
		} else {
			return -1;
		}
	}
}
