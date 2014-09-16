package qiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PatternMatching {

	/**
	 * Given two words (start and end), and a dictionary, find all shortest
	 * transformation sequence(s) from start to end, such that:
	 * 
	 * Only one letter can be changed at a time Each intermediate word must
	 * exist in the dictionary For example,
	 * 
	 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
	 * Return [ ["hit","hot","dot","dog","cog"],
	 * ["hit","hot","lot","log","cog"]]
	 * 
	 * Note: All words have the same length. All words contain only lowercase
	 * alphabetic characters.
	 * 
	 */

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		m_minSize = Integer.MAX_VALUE;
		if (start == null || start.isEmpty() || end == null || end.isEmpty()) {
			throw new IllegalArgumentException();
		}
		List<List<String>> result = new ArrayList<List<String>>();
		if (dict == null || dict.size() == 0) {
			if (start.equals(end)) {
				List<String> path = new ArrayList<String>();
				path.add(start);
				path.add(end);
				result.add(path);
			}
			return result;
		}
		List<List<String>> paths = new ArrayList<List<String>>();
		List<String> p = new ArrayList<String>();
		Set<String> checked = new HashSet<String>();
		findPath(start, end, p, paths, dict, checked);
		for (List<String> path : paths) {
			if (path.size() == m_minSize) {
				result.add(path);
			}
		}
		return result;
		// 1. given the start word, add it to the list, and find the words that
		// are "movable" from dictionary
		// 2. if the end word is one of the "movable" word, return the list
		// 3. if not, for each "movable" word, set it as the new start, repeat 1
		// until all the "paths" are explored
		// 4. loop through the result lists and find the shortest ones

	}

	private int m_minSize = Integer.MAX_VALUE;
	private Set<String> m_similarStrings = new HashSet<String>();
	private Set<String> m_unSimilarStrings = new HashSet<String>();
	private Set<String> m_winners = new HashSet<String>();

	private void findPath(String start, String end, List<String> path,
			List<List<String>> result, Set<String> dict, Set<String> checked) {
		if (!m_winners.contains(start) && path.size() < m_minSize) {
			path.add(start);
			for (String word : dict) {
				if (!checked.contains(word)) {
					checked.add(word);
					if (isSimilar(start, word)) {
						if (word.equals(end)) {
							m_winners.add(start);
							if (path.size() <= m_minSize - 1
									|| result.size() == 0) {
								List<String> ladder = new ArrayList<String>(
										path);
								ladder.add(end);
								result.add(ladder);
								m_minSize = ladder.size();
								System.out.println("found a shortest ladder: "
										+ m_minSize);
								printPath(ladder);
							}
						} else {
							if (path.size() < m_minSize) {
								findPath(word, end, path, result, dict, checked);
							}
						}

					}
					checked.remove(word);
				}
			}
			path.remove(start);
		}
	}

	private boolean isSimilar(String a, String b) {
		String c = a + ":" + b;
		if (m_similarStrings.contains(c)) {
			return true;
		} else if (m_unSimilarStrings.contains(c)) {
			return false;
		}
		boolean isSimilar = false;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				if (isSimilar) {
					m_unSimilarStrings.add(c);
					return false;
				} else {
					isSimilar = true;
				}
			}
		}
		if (isSimilar) {
			m_similarStrings.add(c);
		}
		return isSimilar;
	}

	public static void print(List<List<String>> result) {
		for (List<String> path : result) {
			printPath(path);
		}

	}

	public static void printPath(List<String> path) {
		for (String s : path) {
			System.out.print(s);
			System.out.print("->");
		}
		System.out.println(";");
	}
}
