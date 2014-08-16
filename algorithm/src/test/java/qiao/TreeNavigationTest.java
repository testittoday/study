package qiao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import qiao.Node;
import qiao.TreeNavigation;

/**
 * 
 * @author liqiao
 * 
 */
public class TreeNavigationTest {
	Node a = new Node("A", 10, null);
	Node b = new Node("B", 2, null);
	Node c = new Node("C", 5, null);
	Node x = new Node("X", 3, new Node[] { a, b, c });
	Node a1 = new Node("A", 10, null);
	Node b1 = new Node("B", 2, null);
	Node z = new Node("Z", 8, new Node[] { a1, b1 });
	Node c1 = new Node("C", 5, null);
	Node y = new Node("Y", 13, new Node[] { z, c1 });

	@Before
	public void setUp() {
		x.setParent(null);
		a.setParent(x);
		b.setParent(x);
		c.setParent(x);
		y.setParent(null);
		a1.setParent(z);
		b1.setParent(z);
		z.setParent(y);
		c1.setParent(y);
	}

	@Test
	public void testAreLeafNodesInSameOrder() {
		assertTrue(TreeNavigation.areLeafNodesInSameOrder(x, y));
		assertTrue(TreeNavigation.areLeafNodesInSameOrder2(x, y));
		assertTrue(TreeNavigation.areLeafNodesInSameOrder3(x, y));
		System.out.println("*******************");

		Node tree1 = new Node("X", new Node[] { new Node("A", null),
				new Node("B", null), new Node("C", null) });
		// Node tree1 = new Node("X", new Node[] { new Node("A", null),
		// new Node("B", null)});
		Node tree2 = new Node("Y", new Node[] {
				new Node("Z", new Node[] { new Node("A", null),
						new Node("B", null) }), new Node("C", null) });
		// assertTrue(TreeNavigation.areLeafNodesInSameOrder(tree1, tree2));
		assertTrue(TreeNavigation.areLeafNodesInSameOrder2(tree1, tree2));
	}

	@Test
	public void testFindNodesInrange() {
		StringBuilder nodesInRange = new StringBuilder();
		TreeNavigation.findNodesInRange(x, 0, 10, nodesInRange);
		assertTrue("XBC".equals(nodesInRange.toString()));
		nodesInRange.delete(0, nodesInRange.length());
		TreeNavigation.findNodesInRange(y, 0, 10, nodesInRange);
		assertTrue("ZBC".equals(nodesInRange.toString()));
		System.out.println("*******************");
	}
}
