/**
 *
 * $Id: $
 *
 */

package zhan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author liqiao
 */
public class TreeNavigation {
    public static void collectOrderedLeafNodes(Node root, Stack<String> result) {
        if (root.isLeaf()) {
            result.push(root.getName());
        } else {
            Node[] children = root.getChildren();
            for (Node child : children) {
                collectOrderedLeafNodes(child, result);
            }
        }
    }
    
	public static boolean areLeafNodesInSameOrder(Node tree1, Node tree2) {
		Stack<String> leafNodesA = new Stack<String>();
		collectOrderedLeafNodes(tree1, leafNodesA);
		// printStack(leafNodesA);
		Stack<String> leafNodesB = new Stack<String>();
		collectOrderedLeafNodes(tree2, leafNodesB);
		// printStack(leafNodesB);
		return leafNodesA.equals(leafNodesB);
	}
    
    public static boolean areLeafNodesInSameOrder2(Node tree1, Node tree2) {
        List<String> leafNodesA = new ArrayList<String>();
        collectOrderedLeafNodes(tree1, leafNodesA);
        // printStack(leafNodesA);
        return hasSameOrderedLeafNodes(tree2, leafNodesA);
        // printStack(leafNodesB);
    }
    
    public static void collectOrderedLeafNodes(Node root, List<String> result) {
        if (root.isLeaf()) {
            result.add(root.getName());
        } else {
            Node[] children = root.getChildren();
            for (Node child : children) {
                collectOrderedLeafNodes(child, result);
            }
        }
    }
    
    public static boolean hasSameOrderedLeafNodes(Node root, List<String> target) {
        boolean isSame = true;
        if (root == null && !target.isEmpty()) {
            return false;
        }
        if (root != null && target.isEmpty()) {
            return false;
        }
        if (root.isLeaf()) {
            isSame = root.getName().equals(target.get(0));
            target.remove(0);
        } else {
            Node[] children = root.getChildren();
            for (Node child : children) {
                isSame = hasSameOrderedLeafNodes(child, target) && isSame;
            }
        }
        return isSame;
    }
    
    public static void printStack(Stack<String> s) {
        while (!s.empty()) {
            System.out.print(s.pop());
        }
        System.out.println("");
    }
    
}
