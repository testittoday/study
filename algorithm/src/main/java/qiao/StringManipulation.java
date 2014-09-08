package qiao;

public class StringManipulation {
	public static boolean isPalindrome(int number) {
		String numberString = String.valueOf(number);
		StringBuilder sb = new StringBuilder(numberString);
		sb.reverse();
		String reversedNumberStr = sb.toString();
		System.out.println(reversedNumberStr);
		return numberString.equals(reversedNumberStr);
	}

	public static boolean isPalindromic(char[] chars, int start, int end) {
		if (chars == null || chars.length == 0 || start >= end) {
			throw new IllegalArgumentException();
		} else {
			do {
				if (chars[start] != chars[end]) {
					return false;
				} else {
					start++;
					end--;
				}
			} while (start < end);
			return true;
		}
	}

	/**
	 * Accepted by the online judge
	 * 
	 * @param chars
	 * @param start
	 * @return
	 */
	public static String findLargestPalindromicStr(char[] chars, int start) {
		String largest = String.valueOf(chars[0]);
		for (int i = start; i < chars.length - largest.length(); i++) {
			for (int j = i + largest.length(); j < chars.length; j++) {
				if (isPalindromic(chars, i, j)
						&& (j - i + 1 > largest.length())) {
					StringBuilder sb = new StringBuilder();
					for (int m = i; m <= j; m++) {
						sb.append(chars[m]);
					}
					largest = sb.toString();
				}
			}
		}
		return largest;
	}

	/**
	 * Accepted by the online judge
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		String[] words = s.split("\\s+");
		if (words.length == 0) {
			return "";
		} else if (words.length == 1) {
			return words[0];
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = words.length - 1; i >= 0; i--) {
				sb.append(words[i]);
				if (i != 0) {
					sb.append(" ");
				}
			}
			return sb.toString();
		}
	}

	/**
	 * 
	 * Problem Description:
	 * 
	 * Reverse digits of an integer.
	 * Example1: x = 123, return 321 Example2: x = -123, return -321
	 * 
	 * Accepted by the Online Judge
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		StringBuilder sb = new StringBuilder();
		boolean isNegative = x < 0;
		x = Math.abs(x);
		sb.append(String.valueOf(x));
		sb.reverse();
		int result = 0;
		try {
			result = Integer.parseInt(sb.toString());
		} catch (Exception ex) {
			throw ex;
		}
		if (isNegative) {
			result = result * (-1);
		}
		return result;
	}
}
