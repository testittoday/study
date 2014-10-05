package qiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given:
 * 
 * start = "hit"
 * 
 * end = "cog"
 * 
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * Return
 * 
 * [
 * 
 * ["hit","hot","dot","dog","cog"],
 * 
 * ["hit","hot","lot","log","cog"]
 * 
 * ]
 * 
 * @author liqiao
 * 
 */
public class WordLadder {
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> ladders = new ArrayList<List<String>>();
		int minSize = Integer.MAX_VALUE;
		Set<String> visited = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		Queue<Stack<String>> steps = new LinkedList<Stack<String>>();
		int N = start.length();
		q.add(start);
		steps.add(new Stack<String>());
		while (!q.isEmpty()) {
			String word = q.poll();
			visited.add(word);
			Stack<String> step = steps.poll();
			step.push(word);
			if (minSize > step.size()) {
				char[] wordChar = word.toCharArray();
				for (int i = 0; i < N; i++) { // for every character in the word
					char saved = wordChar[i];
					for (char c = 'a'; c <= 'z'; c++) { // try every char
						wordChar[i] = c;
						String str = new String(wordChar);
						if (str.equals(end)) {
							List<String> ladder = new ArrayList<String>(step);
							ladder.add(str);
							ladders.add(ladder);
							if (minSize > ladder.size()) {
								minSize = ladder.size();
							}
						}
						if (dict.contains(str) && !visited.contains(str)) {
							q.add(str);
							Stack<String> newStep = new Stack<String>();
							newStep.addAll(step);
							steps.add(newStep);
						}
					}
					wordChar[i] = saved;
				}

			}
		}

		List<List<String>> result = new ArrayList<List<String>>();
		for (List<String> ladder : ladders) {
			if (minSize == ladder.size()) {
				result.add(ladder);
			}
		}
		return result;
	}
}
