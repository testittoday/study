package liheng;

import static org.junit.Assert.*;

import org.junit.Test;

import qiao.Node;
import qiao.TreeNavigation;

/**
 * 
 * @author liqiao
 * 
 */
public class TreeNavigationTest {

	@Test
	public void testAreLeafNodesInSameOrder() {
		Node tree1 = new Node("X", new Node[] { new Node("A", null),
				new Node("B", null), new Node("C", null) });
		Node tree2 = new Node("Y", new Node[] {
				new Node("Z", new Node[] { new Node("A", null),
						new Node("B", null) }), new Node("C", null) });
		assertTrue(TreeNavigation.areLeafNodesInSameOrder(tree1, tree2));
		assertTrue(TreeNavigation.areLeafNodesInSameOrder2(tree1, tree2));
	}

}
