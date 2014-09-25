package qiao;

/**
 * A simplified implementation of the hash table, supporting these operations:
 * 
 * put, get, size, remove
 * 
 * it supports null key and null value
 * 
 * @author liqiao
 * 
 * @param <K>
 * @param <V>
 */
public class MyHashTable<K, V> {
	private MyLinkedListNode[] m_objects;
	private static final int DEFAULT_BUCKET_COUNT = 10000;
	private int m_size;
	private V m_nullValue;
	private int m_bucketCount;

	public MyHashTable() {
		this(DEFAULT_BUCKET_COUNT);
	}

	MyHashTable(int bucketCount) {
		m_bucketCount = bucketCount;
		m_objects = new MyLinkedListNode[m_bucketCount];
	}

	public synchronized V get(K key) {
		V value = null;
		if (key == null) {
			return m_nullValue;
		} else {
			MyLinkedListNode valueNode = m_objects[getBucketNumber(key)];
			while (valueNode != null) {
				if (key.equals(valueNode.key)) {
					return (V) valueNode.value;
				}
				valueNode = valueNode.next;
			}
		}
		return value;
	}

	public synchronized void put(K key, V value) {
		if (key == null) {
			m_nullValue = value;
			m_size++;
		} else {
			int bucketNumber = getBucketNumber(key);
			MyLinkedListNode valueNode = m_objects[bucketNumber];
			if (valueNode == null) {
				valueNode = new MyLinkedListNode(key, value);
				m_objects[bucketNumber] = valueNode;
			} else {
				if (key.equals(valueNode.key)) {
					valueNode.value = value;
				} else {
					MyLinkedListNode next = valueNode.next;
					MyLinkedListNode tail = valueNode;
					while (next != null) {
						if (key.equals(next.key)) {
							next.value = value;
							return;
						}
						tail = next;
						next = next.next;
					}
					MyLinkedListNode newTail = new MyLinkedListNode(key, value);
					tail.next = newTail;
					m_size++;
				}
			}
		}
	}

	public synchronized int size() {
		return m_size;
	}

	public synchronized V remove(K key) {
		if (key == null) {
			m_nullValue = null;
			m_size--;
			return m_nullValue;
		} else {
			int bucketNumber = getBucketNumber(key);
			MyLinkedListNode valueNode = m_objects[bucketNumber];
			MyLinkedListNode previous = null;
			MyLinkedListNode next = null;
			while (valueNode != null) {
				next = valueNode.next;
				if (key.equals(valueNode.key)) {
					valueNode.next = null;
					if (previous != null) {
						previous.next = next;
					} else {
						m_objects[bucketNumber] = next;
					}
					m_size--;
					return (V) valueNode.value;
				}
				previous = valueNode;
				valueNode = valueNode.next;
			}
		}
		return null;
	}

	private int getBucketNumber(K key) {
		int hashCode = key.hashCode();
		return hashCode % m_bucketCount;

	}
}
