package qiao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liqiao
 * 
 */

public class PhonePadMapping {

	private static final Map<Byte, byte[]> s_digitLetterMap = new HashMap<Byte, byte[]>();
	private static final byte[] NO_MAPPING = new byte[0];
	private static final byte[] THREE_LETTERS = new byte[3];
	private static final byte[] FOUR_LETTERS = new byte[4];
	static {
		byte nextLetter = 'A';
		for (byte digit = '2'; digit <= '9'; digit++) {
			byte[] letters = getByteArray(digit);
			for (byte letter = nextLetter; letter <= 'Z'; letter++) {
				letters[letter - nextLetter] = letter;
				if (isMappingComplete(digit, letter, nextLetter)) {
					s_digitLetterMap.put(digit, letters);
					nextLetter = ++letter;
					break;
				}
			}
			System.out.println((char) digit + ":"
					+ new String(s_digitLetterMap.get(digit)));
		}

	}

	private PhonePadMapping() {
	}

	private static byte[] getByteArray(byte digit) {
		if (isFourLetterDigit(digit)) {
			Arrays.fill(FOUR_LETTERS, (byte) 0);
			return FOUR_LETTERS;
		} else {
			Arrays.fill(THREE_LETTERS, (byte) 0);
			return new byte[3];
		}
	}

	private static boolean isMappingComplete(byte digit, byte letter,
			byte lastLetter) {
		if (isFourLetterDigit(digit)) {
			return letter - lastLetter >= 3;
		} else {
			return letter - lastLetter >= 2;
		}
	}

	private static boolean isFourLetterDigit(byte digit) {
		return digit == '7' || digit == '9';
	}

	/**
	 * 
	 * 
	 * @param digit
	 *            0~9
	 * @return
	 */
	public static byte[] getLetters(byte digit) {
		byte[] result = s_digitLetterMap.get(digit);
		if (result == null) {
			result = NO_MAPPING;
		}
		return result;
	}

}
