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
		// if (start < chars.length - 1) {
		// findLargestPalindromicStr(chars, largest, start + 1);
		// }
		return largest;
	}
}
