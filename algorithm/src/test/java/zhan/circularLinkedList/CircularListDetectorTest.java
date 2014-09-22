package zhan.circularLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularListDetectorTest {

	@Test
	public void test() {
		LinkedListNode a1 = new LinkedListNode(1);
		LinkedListNode a2 = new LinkedListNode(2);
		LinkedListNode a3 = new LinkedListNode(3);
		LinkedListNode a4 = new LinkedListNode(4);
		LinkedListNode a5 = new LinkedListNode(5);
		LinkedListNode a6 = new LinkedListNode(6);
		LinkedListNode a7 = new LinkedListNode(7);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;

		CircularListDetector detector = new CircularListDetector();
		assertFalse(detector.containCycle(a1));
		a7.next = a3;
		assertTrue(detector.containCycle(a1));
		assertTrue(a3 == detector.getCycleStartNode(a1));

	}

}
