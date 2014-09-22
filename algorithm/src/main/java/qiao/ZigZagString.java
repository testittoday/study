package qiao;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * 
 * @author liqiao
 * 
 */
public class ZigZagString {
	/**
	 * Accepted by the Online Judge
	 * @param s
	 * @param nRows
	 * @return
	 */
	public static String convert(String s, int nRows) {
		// validate input
		if (s == null || nRows < 1 || s.length() <= nRows || nRows <= 1) {
			return s;
		}
		// loop through all the characters in s
		// create arrays that has length nRows
		// fill arrays based on this rule:
		// if the s.index mod nRows is 0 and the filled flag is false, fill the
		// array
		// if the s.index mod nRows is 0 and the filled flag is true, fill only
		// the element at array.length - 2
		// otherwise only fill the array at the current index and decrease the
		// index
		List<char[]> zig = new ArrayList<char[]>();
		boolean isFilled = false;
		char[] chars = s.toCharArray();
		int zigIndex = 0;
		for (int i = 0; i < chars.length; i++) {
			char[] cross = new char[nRows];
			if (zigIndex == 0) {
				if (!isFilled) {
					for (int c = 0; c < cross.length && i < chars.length; c++, i++) {
						cross[c] = chars[i];
					}
					i--;
					isFilled = true;
				} else {
					isFilled = false;
					zigIndex = nRows - 2;
					if (zigIndex == 0) {
						i--;
						continue;
					}
					if (zigIndex > 0) {
						cross[zigIndex] = chars[i];
						zigIndex--;
					}
				}
			} else {
				cross[zigIndex] = chars[i];
				zigIndex--;
			}
			zig.add(cross);
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			for (char[] z : zig) {
				if (z[i] > 0) {
					result.append(z[i]);
				}
			}
		}
		return result.toString();
	}
}
