package qiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SuperRecursion {

	/**
	 * Problem Description: Given a digit string, return all possible letter
	 * combinations that the number could represent on a phone pad.
	 * 
	 * Accepted by the Online Judge
	 * 
	 */
	private static Map<String, char[]> DIGIT_LETTER_MAP = new HashMap<String, char[]>();
	static {
		DIGIT_LETTER_MAP.put("2", new char[] { 'a', 'b', 'c' });
		DIGIT_LETTER_MAP.put("3", new char[] { 'd', 'e', 'f' });
		DIGIT_LETTER_MAP.put("4", new char[] { 'g', 'h', 'i' });
		DIGIT_LETTER_MAP.put("5", new char[] { 'j', 'k', 'l' });
		DIGIT_LETTER_MAP.put("6", new char[] { 'm', 'n', 'o' });
		DIGIT_LETTER_MAP.put("7", new char[] { 'p', 'q', 'r', 's' });
		DIGIT_LETTER_MAP.put("8", new char[] { 't', 'u', 'v' });
		DIGIT_LETTER_MAP.put("9", new char[] { 'w', 'x', 'y', 'z' });

	}

	public List<String> letterCombinations(String digits) {
		if (digits == null) {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<String>();
		if (digits.isEmpty()) {
			result.add("");
		} else {
			StringBuilder sb = new StringBuilder();
			Set<String> uniqueResult = new HashSet<String>();
			translate(sb, digits.toCharArray(), 0, uniqueResult);
			result.addAll(uniqueResult);
		}
		return result;
	}

	private void translate(StringBuilder sb, char[] digits, int dIndex,
			Set<String> result) {
		for (int d = dIndex; d < digits.length; d++) {
			char[] letters = DIGIT_LETTER_MAP.get(String.valueOf(digits[d]));
			for (int i = 0; i < letters.length; i++) {
				sb.append(letters[i]);
				if (sb.length() == digits.length) {
					result.add(sb.toString());
				} else {
					translate(sb, digits, d + 1, result);
				}
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
