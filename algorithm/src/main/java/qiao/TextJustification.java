package qiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * For example, words:
 * 
 * ["This", "is", "an", "example", "of", "text", "justification."] L: 16.
 * 
 * Return the formatted lines as:
 * 
 * [ "This    is    an", "example  of text", "justification.  " ]
 * 
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * @author liqiao
 * 
 */
public class TextJustification {
	/**
	 * Accepted by the Online Judge
	 * @param words
	 * @param L
	 * @return
	 */
	public List<String> fullJustify(String[] words, int L) {
		if (words == null || words.length == 0) {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<String>();
		if (words.length == 1) {
			StringBuilder line = new StringBuilder();
			line.append(words[0]);
			if (L > 0) {
				for (int i = 0; i < L - words[0].length(); i++) {
					line.append(" ");
				}
			}
			result.add(line.toString());
			return result;
		}
		List<String> wordsInALine = new ArrayList<String>();
		int lineSize = 0;
		for (int w = 0; w < words.length; w++) {
			String word = words[w];
			if (lineSize + word.length() <= L) {
				wordsInALine.add(word);

			} else {
				int extraSpace = L - lineSize + wordsInALine.size();
				int interval = extraSpace;
				int oddSpace = 0;
				if (wordsInALine.size() > 1) {
					interval = extraSpace / (wordsInALine.size() - 1);
					oddSpace = extraSpace % (wordsInALine.size() - 1);
				}
				StringBuilder aLine = new StringBuilder();
				for (int i = 0; i < wordsInALine.size(); i++) {
					aLine.append(wordsInALine.get(i));
					if (i != wordsInALine.size() - 1
							|| wordsInALine.size() == 1) {
						for (int j = 0; j < interval; j++) {
							aLine.append(" ");
						}
						if (oddSpace > 0) {
							aLine.append(" ");
							oddSpace--;
						}
					}
				}

				result.add(aLine.toString());
				wordsInALine.removeAll(wordsInALine);
				lineSize = 0;
				wordsInALine.add(word);
			}
			lineSize += word.length() + 1;
			if (w == words.length - 1) {
				StringBuilder aLine = new StringBuilder();
				for (int i = 0; i < wordsInALine.size(); i++) {
					aLine.append(wordsInALine.get(i));
					if (i != wordsInALine.size() - 1) {
						aLine.append(" ");
					} else {
						for (int j = 0; j < L - lineSize + 1; j++) {
							aLine.append(" ");
						}
					}
				}
				result.add(aLine.toString());
			}
		}
		return result;
	}
}
