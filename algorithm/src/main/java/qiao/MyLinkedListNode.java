package qiao;

/**
 * 
 * @author liqiao
 * 
 * @param <K>
 * @param <V>
 */

public class MyLinkedListNode<K, V> {
	K key;
	V value;
	MyLinkedListNode next;

	MyLinkedListNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

}