package qiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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
		m_visited = new HashSet<String>();
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
		Stack<String> p = new Stack<String>();
		p.push(start);
		Set<String> checked = new HashSet<String>();
		checked.add(start);
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

	// private Set<String> m_similarStrings = new HashSet<String>();
	// private Set<String> m_unSimilarStrings = new HashSet<String>();
	private Set<String> m_visited = new HashSet<String>();

	private void findPath(String start, String end, Stack<String> path,
			List<List<String>> result, Set<String> dict, Set<String> checked) {
		if (!m_visited.contains(start) && path.size() < m_minSize) {
			for (String word : dict) {
				if (!checked.contains(word)) {
					checked.add(word);
					if (isSimilar(start, word)) {
						path.push(word);
						if (word.equals(end)) {
							// m_visited.add(path.elementAt(1));
							if (path.size() <= m_minSize - 1
									|| result.size() == 0) {
								List<String> ladder = new ArrayList<String>(
										path);
								result.add(ladder);
								m_minSize = ladder.size();
								System.out.println("found a shortest ladder: "
										+ m_minSize);
								// printPath(ladder);
							}
						} else {
							if (path.size() < m_minSize) {
								findPath(word, end, path, result, dict, checked);
							}
						}
						path.pop();
					}
					checked.remove(word);
				}
			}

		}
	}

	private boolean isSimilar(String a, String b) {
		String c = a + ":" + b;
		// if (m_similarStrings.contains(c)) {
		// return true;
		// } else if (m_unSimilarStrings.contains(c)) {
		// return false;
		// }
		boolean isSimilar = false;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				if (isSimilar) {
					// m_unSimilarStrings.add(c);
					return false;
				} else {
					isSimilar = true;
				}
			}
		}
		// if (isSimilar) {
		// m_similarStrings.add(c);
		// }
		return isSimilar;
	}

	public static void print(List<List<String>> result) {
		for (List<String> path : result) {
			printPath(path);
		}

	}

	public static void printPath(List<String> path) {
		int i = 0;
		System.out.print("size: " + path.size() + " | ");
		for (String s : path) {
			System.out.print(s);
			if (i < path.size() - 1) {
				System.out.print("->");
			}
			i++;
		}
		System.out.println(";");
	}

	/*
	 * This solution is from leetcode.com. Rather than looping though the words
	 * in the dictionary, it generates words and check if they are in
	 * dictionary.
	 * 
	 * TODO Still need to understand why it works
	 */
	public static int ladderLength(String start, String end, Set<String> dict) {
		Set<String> visited = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		Queue<Integer> steps = new LinkedList<Integer>();

		int N = start.length();
		q.add(start);
		steps.add(1);

		while (!q.isEmpty()) {
			String word = q.poll();
			visited.add(word);
			int st = steps.poll();
			char[] wordChar = word.toCharArray();

			for (int i = 0; i < N; i++) { // for every character in the word
				char saved = wordChar[i];
				for (char c = 'a'; c <= 'z'; c++) { // try every char
					wordChar[i] = c;
					String str = new String(wordChar);
					if (str.equals(end))
						return st + 1;
					if (dict.contains(str) && !visited.contains(str)) {
						if (!q.contains(str)) {
							q.add(str);
							steps.add(st + 1);
						}

					}
				}
				// st++;
				wordChar[i] = saved;
			}
		}
		return 0;
	}

	public static List<List<String>> findLadders2(String start, String end,
			Set<String> dict) {
		Set<String> visited = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		Queue<Integer> steps = new LinkedList<Integer>();
		List<List<String>> result = new ArrayList<List<String>>();
		int N = start.length();
		q.add(start);
		steps.add(0);
		Stack<String> path = new Stack<String>();
		path.push(start);
		int minSize = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			String word = q.poll();
			visited.add(word);
			int st = steps.poll();
			if (st > minSize) {
				continue;
			}
			char[] wordChar = word.toCharArray();

			for (int i = 0; i < N && st <= minSize; i++) { // for every
															// character in the
															// word
				char saved = wordChar[i];
				for (char c = 'a'; c <= 'z' && st <= minSize; c++) { // try
																		// every
																		// char
					wordChar[i] = c;
					String str = new String(wordChar);
					if (str.equals(end) && st < minSize) {
						List<String> ladder = new ArrayList<String>(path);
						result.add(ladder);
						path.removeAll(path);
						path.push(start);
						minSize = st + 1;
						continue;
					}
					if (dict.contains(str) && !visited.contains(str)) {
						q.add(str);
						path.push(str);
						st++;
						steps.add(st);
						// visited.add(str);
					}

				}
				wordChar[i] = saved;
			}

		}
		return result;
	}
}
