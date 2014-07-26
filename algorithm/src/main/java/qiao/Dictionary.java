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
	private static final Set<String> WORD_LIST = new HashSet<String>();

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
}
