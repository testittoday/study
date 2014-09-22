package qiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
	 * In a given binary tree, find the number of elements that lie in a given
	 * range.
	 * 
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

	/**
	 * Problem Description:
	 * 
	 * Given a binary tree, flatten it to a linked list in-place.
	 * 
	 * For example, Given
	 * 
	 * 1 / \ 2 5 / \ \ 3 4 6 The flattened tree should look like: 1 \ 2 \ 3 \ 4
	 * \ 5 \ 6
	 * 
	 * 
	 * Accepted by the Online Judge
	 * 
	 * @param root
	 */
	public void flatten(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			BinaryTreeNode left = root.left;
			BinaryTreeNode right = root.right;
			root.right = left;
			root.left = null;
			BinaryTreeNode leftRight = left.right;
			if (leftRight != null) {
				while (leftRight.right != null) {
					leftRight = leftRight.right;
				}
				leftRight.right = right;
			} else {
				left.right = right;
			}
			if (left.left != null || left.right != null) {
				flatten(left);
			}
		} else if (root.right != null) {
			flatten(root.right);
		}
	}

	/**
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the
	 * root node down to the farthest leaf node.
	 * 
	 * Accepted by the Online Judge
	 * 
	 * @param root
	 * @return
	 */
	public static int maxDepth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
		}
	}

	/**
	 * Given two binary trees, write a function to check if they are equal or
	 * not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical
	 * and the nodes have the same value.
	 * 
	 * Accepted by the online Judge
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
		if (p != null && q != null) {
			if (p.val == q.val) {
				return isSameTree(p.left, q.left)
						&& isSameTree(p.right, q.right);
			} else {
				return false;
			}
		} else {
			return p == null && q == null;
		}
	}

	/**
	 * Accepted by the Online Judge
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> values = new ArrayList<Integer>();
		TreeNode next = root;
		Stack<TreeNode> unvisited = new Stack<TreeNode>();
		Set<TreeNode> visited = new HashSet<TreeNode>();
		while (next != null) {
			if (next.left != null && !visited.contains(next.left)) {
				unvisited.push(next);
				next = next.left;
				continue;
			} else if (next.right != null && !visited.contains(next.right)) {
				unvisited.push(next);
				next = next.right;
				continue;
			} else {
				// leaf node
				values.add(next.val);
				visited.add(next);
				if (!unvisited.empty()) {
					next = unvisited.pop();
				} else {
					break;
				}
			}
		}
		return values;
	}
	
	
	/**
	 * Given a binary tree, return the preorder traversal of its nodes' values.

		For example:
		Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
		return [1,2,3].
		
		Note: Recursive solution is trivial, could you do it iteratively?
	 */
	
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<Integer> result = new ArrayList<Integer>();
		preorderTraversal(root, result);
		return result;
	}

	private void preorderTraversal(TreeNode root, List<Integer> result) {
		result.add(root.val);
		if (root.left != null) {
			preorderTraversal(root.left, result);
		}
		if (root.right != null) {
			preorderTraversal(root.right, result);
		}
	}
	
	/**
	 * 
	 * preorder without recursion
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversalWithLoop(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> path = new Stack<TreeNode>();
		path.push(root);
		while (!path.empty()) {
			TreeNode node = path.pop();
			result.add(node.val);
			if (node.right != null) {
				path.push(node.right);
			}
			if (node.left != null) {
				path.push(node.left);
			}
		}
		return result;
	}
}
