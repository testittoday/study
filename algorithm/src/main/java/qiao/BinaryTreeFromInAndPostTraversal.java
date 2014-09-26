package qiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author liqiao
 * 
 * 
 * 
 */
public class BinaryTreeFromInAndPostTraversal {
	/**
	 * Observation:
	 * 
	 * 1. the last element in the post order array is the root
	 * 
	 * 2. the first element of both arrays is the left most leaf
	 * 
	 * 
	 * Accepted by the Online Judge
	 * 
	 * 
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0 || postorder == null
				|| postorder.length == 0) {
			return null;
		}
		if (inorder.length != postorder.length) {
			throw new IllegalArgumentException();
		}
		if (inorder.length == 1) {
			return new TreeNode(inorder[0]);
		}
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		if (inorder.length == 2) {
			TreeNode leaf = new TreeNode(postorder[0]);
			if (inorder[0] == postorder[0]) {
				root.left = leaf;
			} else {
				root.right = leaf;
			}
		} else {
			splitTree(inorder, postorder, root);
		}
		return root;
	}

	private static void buildTree(int[] inorder, int[] postorder,
			TreeNode root, boolean isLeft) {
		if (inorder.length == 1) {
			TreeNode leaf = new TreeNode(inorder[0]);
			if (isLeft) {
				root.left = leaf;
			} else {
				root.right = leaf;
			}
			return;
		} else if (inorder.length == 2) {
			TreeNode parent = new TreeNode(postorder[1]);
			TreeNode leaf = new TreeNode(postorder[0]);
			if (inorder[0] == postorder[0]) {
				parent.left = leaf;
			} else {
				parent.right = leaf;
			}
			if (isLeft) {
				root.left = parent;
			} else {
				root.right = parent;
			}
			return;
		} else {
			TreeNode parent = new TreeNode(postorder[postorder.length - 1]);
			if (isLeft) {
				root.left = parent;
			} else {
				root.right = parent;
			}
			splitTree(inorder, postorder, parent);
		}
	}

	private static void splitTree(int[] inorder, int[] postorder,
			TreeNode parent) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorder.length - 1]) {
				if (i != 0) {
					int[] newinorder = Arrays.copyOfRange(inorder, 0, i);
					int[] newpostorder = Arrays.copyOfRange(postorder, 0, i);
					buildTree(newinorder, newpostorder, parent, true);
				}
				if (i < inorder.length - 1) {
					int[] newinorder = Arrays.copyOfRange(inorder, i + 1,
							inorder.length);
					int[] newpostorder = Arrays.copyOfRange(postorder, i,
							postorder.length - 1);
					buildTree(newinorder, newpostorder, parent, false);
				}
				break;
			}
		}
	}
}
