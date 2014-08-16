package qiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author liqiao
 * 
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

	public static boolean areLeafNodesInSameOrder3(Node tree1, Node tree2) {
		Node leaf1 = getNextLeaf(tree1);
		Node leaf2 = getNextLeaf(tree2);
		if (leaf1.getName().equals(leaf2.getName())) {
			do {
				leaf1 = gotoNextLeaf(leaf1);
				leaf2 = gotoNextLeaf(leaf2);
				if ((leaf1 == null && leaf2 != null)
						|| (leaf1 != null && leaf2 == null)) {
					return false;
				} else if (leaf1 == null && leaf2 == null) {
					break;
				}
			} while (leaf1.getName().equals(leaf2.getName()));
			return true;
		} else {
			return false;
		}
	}

	public static Node gotoNextLeaf(Node node) {
		if (node.getParent() != null) {
			Node parent = node.getParent();
			if (node.getChildIndex() < parent.getChildren().length - 1) {
				return getNextLeaf(parent.getChildren()[node.getChildIndex() + 1]);
			} else {
				return gotoNextLeaf(parent);
			}
		} else {
			return null;
		}
	}

	public static Node getNextLeaf(Node tree) {
		Node nextLeaf = null;
		if (tree.getChildren() == null || tree.getChildren().length == 0) {
			nextLeaf = tree;
			System.out.print(nextLeaf.getName());
		} else {
			for (Node child : tree.getChildren()) {
				nextLeaf = getNextLeaf(child);
			}
		}
		return nextLeaf;
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
		if (root.isLeaf()) {
			isSame = root.getName().equals(target.get(0));
			target.remove(0);
		} else {
			Node[] children = root.getChildren();
			for (Node child : children) {
				isSame = hasSameOrderedLeafNodes(child, target) && isSame;
				if (!isSame) {
					break;
				}
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
	
	/**
	 * In a given binary tree, find the number of elements that lie in a given range.
	 * @param tree
	 * @param min
	 * @param max
	 * @param target
	 */

	public static void findNodesInRange(Node<Integer> tree, int min, int max,
			StringBuilder target) {
		if (tree.getValue() > min && tree.getValue() < max) {
			System.out.print(tree.getName());
			target.append(tree.getName());
		}
		if (tree.getChildren() != null && tree.getChildren().length > 0) {
			for (Node<Integer> child : tree.getChildren()) {
				findNodesInRange(child, min, max, target);
			}
		}
	}
}
