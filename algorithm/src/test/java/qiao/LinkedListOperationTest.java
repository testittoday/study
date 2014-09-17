package qiao;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LinkedListOperationTest {

	Set<ListNode> nodes = new HashSet<ListNode>();

	// @Test
	public void testInsert() {
		ListNode a1 = new ListNode(null, 1);
		ListNode a2 = new ListNode(null, 5);
		a1.next = a2;
		ListNode a3 = new ListNode(a1, 10);
		a2.next = a3;
		print(a1);
		// LinkedListOperation.insert(a2, 6);
		// nodes.removeAll(nodes);
		// print(a1);
		// LinkedListOperation.insert(a1, 6);
		// nodes.removeAll(nodes);
		// print(a1);
		LinkedListOperation.insert(a3, 6);
		nodes.removeAll(nodes);
		print(a1);

	}

	private void print(ListNode node) {
		if (node != null && !nodes.contains(node)) {
			System.out.print(node.val);
			System.out.print("->");
			nodes.add(node);
			print(node.next);
		} else {
			if (node != null) {
				System.out.print(node.val);
			}
			System.out.println(";");
		}
	}

	@Test
	public void testSort() {
		int[] a = new int[] { 1, 7, 3, 4, 5, 6, 2 };
		ListNode head = createLinkedList(a);
		print(head);
		nodes.removeAll(nodes);
		head = LinkedListOperation.sortList(head);
		print(head);
	}

	private ListNode createLinkedList(int[] values) {
		ListNode next = null;
		for (int i = values.length - 1; i >= 0; i--) {
			ListNode aNode = new ListNode(next, values[i]);
			next = aNode;
		}
		return next;
	}

}
