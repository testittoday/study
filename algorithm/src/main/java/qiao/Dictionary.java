package qiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liqiao
 * 
 */
public class Dictionary {
	private static final String[] NO_WORDS = new String[0];
	public static final Set<String> WORD_LIST = new HashSet<String>();

	static {
		try {
			InputStream is = Dictionary.class.getClassLoader()
					.getResourceAsStream("all_words.txt");
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			String word = null;
			do {
				word = reader.readLine();
				if (word != null && word.length() > 0) {
					WORD_LIST.add(word.replaceAll("\\s+", "").toUpperCase());
				}
			} while (word != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String[] getWords(int number) {
		String numberString = String.valueOf(number);
		return getWords(numberString);
	}

	public static String[] getWords(String number) {
		if (number == null || number.length() <= 0) {
			return NO_WORDS;
		}
		byte[][] letters = new byte[number.length()][];
		Set<String> letterCombination = new HashSet<String>();
		int i = 0;
		for (char c : number.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException("invalid number: " + number);
			} else {
				letters[i++] = PhonePadMapping.getLetters((byte) c);
			}
		}
		collectLetterCombination(letters, 0, new byte[letters.length],
				letterCombination);

		System.out.println("Combinations: ");
		Set<String> words = new HashSet<String>();
		for (String combination : letterCombination) {
			System.out.print(combination);
			System.out.print(", ");
			if (WORD_LIST.contains(combination)) {
				words.add(combination);
			}
		}
		System.out.println("***");
		System.out.println("Words: ");
		for (String word : words) {
			System.out.print(word);
			System.out.print(", ");
		}
		System.out.println("***");
		return words.toArray(new String[0]);
	}

	public static void collectLetterCombination(byte[][] letters,
			int wordIndex, byte[] word, Set<String> words) {
		if (wordIndex == letters.length) {
			words.add(new String(word));
		} else {
			byte[] letterSelection = letters[wordIndex];
			for (byte letter : letterSelection) {
				word[wordIndex] = letter;
				collectLetterCombination(letters, wordIndex + 1, word, words);
			}
		}
	}

	/**
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary
	 * words.
	 * 
	 * Accepted by online Judge
	 * 
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		// return true if the string itself is a word
		if (dict.contains(s)) {
			return true;
		}
		// go through the string to see if a word could be matched; if yes,
		// check if the rest of the string could be broken
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char cc = s.charAt(s.length() - 1 - i);
			boolean firstLetterExists = false;
			boolean lastLetterExists = false;
			for (String d : dict) {
				if (d.indexOf(c) >= 0) {
					firstLetterExists = true;
				}
				if (d.indexOf(cc) >= 0) {
					lastLetterExists = true;
				}
				if (firstLetterExists && lastLetterExists) {
					break;
				}
			}
			if (!firstLetterExists || !lastLetterExists) {
				return false;
			}
			String ss = s.substring(0, i + 1);
			String sss = s.substring(i + 1);
			if (dict.contains(ss)) {
				if (wordBreak(sss, dict)) {
					return true;
				}
			} else {
				if (dict.contains(sss)) {
					if (wordBreak(ss, dict)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
