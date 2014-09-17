package qiao;

public class LinkedListOperation {

	/**
	 * Given a node from a cyclic linked list which has been sorted, write a
	 * function to insert a value into the list such that it remains a cyclic
	 * sorted list. The given node can be any single node in the list.
	 */
	public static void insert(ListNode n, int value) {
		// Assuming the cycled list is sorted in a way that the next node has a
		// greater value
		// 1. find the component before/after the new node
		// 2. insert the new node
		if (n.next != null) {
			ListNode previous = findNode(n, value);
			ListNode next = previous.next;
			ListNode newNode = new ListNode(next, value);
			previous.next = newNode;
		} else {
			ListNode newNode = new ListNode(n, value);
			n.next = newNode;
		}
	}

	private static ListNode findNode(ListNode n, int value) {
		if (n.next.val > value) {
			return n;
		} else {
			return findNode(n.next, value);
		}
	}

	/**
	 * Problem Description: Given a list, rotate the list to the right by k
	 * places, where k is non-negative. * For example: Given 1->2->3->4->5->NULL
	 * and k = 2, return 4->5->1->2->3->NULL.
	 * 
	 * Accepted by the Online Judge
	 * 
	 */
	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0 || head.next == null) {
			return head;
		}
		ListNode newHead = head;
		for (int i = 0; i < n; i++) {
			newHead = rotateRight(newHead);
		}
		return newHead;
	}

	public static ListNode rotateRight(ListNode head) {
		ListNode tail = head.next;
		ListNode newTail = null;
		while (tail != null) {
			if (tail.next != null) {
				newTail = tail;
				tail = tail.next;
			} else {
				break;
			}
		}
		tail.next = head;
		if (newTail != null) {
			newTail.next = null;
		} else {
			head.next = null;
		}
		return tail;
	}

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		boolean swapped = false;
		boolean foundMin = false;
		ListNode newHead = head;
		ListNode originalHead = head;
		ListNode next = head.next;
		ListNode minNode = head;
		while (next != null) {
			if (next.val < newHead.val) {
				swapValue(next, newHead);
				if (minNode.val > newHead.val) {
					minNode = newHead;
					foundMin = true;
				}
				swapped = true;
			}
			newHead = next;
			next = next.next;
			if (next == null) {
				if (foundMin) {
					swapValue(minNode, head);
				}
				head = head.next;
			}
			if (swapped) {
				newHead = head;
				next = head.next;
				swapped = false;
			}

		}
		return originalHead;
	}

	private static void swapValue(ListNode a, ListNode b) {
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
	}

}
