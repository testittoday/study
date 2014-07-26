/**
 *
 *
 * Write a function to check if any two trees (not
 * necessary binary tree) have the same order of leaf nodes.
 * 
 * For example:
 * 
 * The following two trees have the same order of leaf nodes.
 * 
 * T1 leaf nodes: A, then B, then C
 * T2 leaf nodes: A, then B, then C
 * 
 * T1:
 * 
 *    X
 *  / | \
 * A  B  C
 * 
 * T2:
 * 
 *      Y
 *     / \
 *    Z   C
 *   / \
 *  A   B
 * 
 * $Id: $
 *
 */

package zhan;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 *
 * @author liqiao
 */
public class TreeNavigationTest {
    
    @Test
    public void testAreLeafNodesInSameOrder() {
        Node tree1 = new Node("X", new Node[] { new Node("A", null),
            new Node("B", null), new Node("C", null) });
//        Node tree1 = new Node("X", new Node[] { new Node("A", null),
//            new Node("B", null)});
        Node tree2 = new Node("Y", new Node[] {
            new Node("Z", new Node[] { new Node("A", null),
                new Node("B", null) }), new Node("C", null) });
//		assertTrue(TreeNavigation.areLeafNodesInSameOrder(tree1, tree2));
        assertTrue(TreeNavigation.areLeafNodesInSameOrder2(tree1, tree2));
    }
    
}
