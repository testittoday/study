package qiao;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * Input: 2,[set(2,1),set(2,2),get(2),set(1,1),set(4,1),get(2)] Output: [2,2]
 * Expected: [2,-1]
 * 
 * Input:	10,[set(10,13),set(3,17),set(6,11),set(10,5),set(9,10),get(13),set(2,19),get(2),get(3),set(5,25),get(8),set(9,22),set(5,5),set(1,30),get(11),set(9,12),get(7),get(5),get(8),get(9),set(4,30),set(9,3),get(9),get(10),get(10),set(6,14),set(3,1),get(3),set(10,11),get(8),set(2,14),get(1),get(5),get(4),set(11,4),set(12,24),set(5,18),get(13),set(7,23),get(8),get(12),set(3,27),set(2,12),get(5),set(2,9),set(13,4),set(8,18),set(1,7),get(6),set(9,29),set(8,21),get(5),set(6,30),set(1,12),get(10),set(4,15),set(7,22),set(11,26),set(8,17),set(9,29),get(5),set(3,4),set(11,30),get(12),set(4,29),get(3),get(9),get(6),set(3,4),get(1),get(10),set(3,29),set(10,28),set(1,20),set(11,13),get(3),set(3,12),set(3,8),set(10,9),set(3,26),get(8),get(7),get(5),set(13,17),set(2,27),set(11,15),get(12),set(9,19),set(2,15),set(3,16),get(1),set(12,17),set(9,1),set(6,19),get(4),get(5),get(5),set(8,1),set(11,7),set(5,2),set(9,28),get(1),set(2,2),set(7,4),set(4,22),set(7,24),set(9,26),set(13,28),set(11,26)]
Output:	[-1,19,17,-1,-1,-1,5,-1,12,3,5,5,1,-1,30,5,30,-1,-1,24,18,-1,18,11,18,24,4,29,-1,12,11,29,17,-1,18,24,20,29,18,18,20]
Expected:	[-1,19,17,-1,-1,-1,5,-1,12,3,5,5,1,-1,30,5,30,-1,-1,24,18,-1,18,-1,18,-1,4,29,30,12,-1,29,17,22,18,-1,20,-1,18,18,20]
 * 
 * @author liqiao
 * 
 */
public class LRUCache {
	int m_capacity;
	Map<Integer, Integer> m_cache;
	Map<Integer, Integer> m_frequency;

	public LRUCache(int capacity) {
		m_capacity = capacity;
		m_cache = new HashMap<Integer, Integer>(capacity);
		m_frequency = new HashMap<Integer, Integer>(capacity);
	}

	public int get(int key) {
		if (m_cache.get(key) != null) {
			int frequency = m_frequency.get(key);
			m_frequency.put(key, frequency + 1);
			return m_cache.get(key);
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (m_cache.get(key) == null) {
			int visitedCount = 0;
			int lowestFrequencyKey = getLowestFrequencyKey();
			int lowestFrequency = m_frequency.get(lowestFrequencyKey);
			visitedCount = lowestFrequency + 1;
			if (m_cache.size() == m_capacity) {
				m_cache.remove(lowestFrequencyKey);
				m_frequency.remove(lowestFrequencyKey);
			}
			m_cache.put(key, value);
			m_frequency.put(key, Integer.valueOf(visitedCount));
		} else {
			m_cache.put(key, value);
		}
	}

	private int getLowestFrequencyKey() {
		int lowestFrequency = Integer.MAX_VALUE;
		int lowestFrequencyKey = -1;
		for (Map.Entry<Integer, Integer> entry : m_frequency.entrySet()) {
			if (entry.getValue() < lowestFrequency) {
				lowestFrequency = entry.getValue();
				lowestFrequencyKey = entry.getKey();
			}
		}
		return lowestFrequencyKey;
	}
}