package qiao;

public class BST {

	/**
	 * 
	 * Problem Description:
	 * 
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 * 
	 * Got hint from leetcode and Accepted by the online Judge
	 * 
	 * @param num
	 * @return
	 */
	public static TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		if (num.length == 1) {
			return new TreeNode(num[0]);
		}
		if (num.length == 2) {
			TreeNode node = new TreeNode(num[0]);
			node.right = new TreeNode(num[1]);
			return node;
		}
		if (num.length % 2 == 0) {
			TreeNode n = new TreeNode(num[num.length / 2]);
			int[] left = new int[num.length / 2];
			System.arraycopy(num, 0, left, 0, num.length / 2);
			n.left = sortedArrayToBST(left);
			int[] right = new int[num.length / 2 - 1];
			System.arraycopy(num, num.length / 2 + 1, right, 0,
					num.length / 2 - 1);
			n.right = sortedArrayToBST(right);
			return n;
		} else {
			TreeNode n = new TreeNode(num[num.length / 2]);
			int[] left = new int[num.length / 2];
			System.arraycopy(num, 0, left, 0, num.length / 2);
			n.left = sortedArrayToBST(left);
			int[] right = new int[num.length / 2];
			System.arraycopy(num, num.length / 2 + 1, right, 0, num.length / 2);
			n.right = sortedArrayToBST(right);
			return n;
		}
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		} else {
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
			return Math.abs(leftHeight - rightHeight) <= 1;
		}
	}

	public static int getHeight(TreeNode top) {
		if (top.left == null && top.right == null) {
			return 1;
		}
		int height = 0;
		if (top.left != null) {
			height = Math.max(height, getHeight(top.left) + 1);
		}
		if (top.right != null) {
			height = Math.max(height, getHeight(top.right) + 1);
		}
		return height;
	}

	public static TreeNode balance(TreeNode root) {
		TreeNode left = root.left;
		TreeNode leftRight = left.right;
		left.right = root;
		root.left = leftRight;
		return left;
	}

	public static boolean exists(TreeNode root, int value) {
		if (root != null) {
			if (root.val == value) {
				return true;
			} else {
				if (value < root.val) {
					if (root.left != null) {
						return exists(root.left, value);
					} else {
						return false;
					}
				} else {
					if (root.right != null) {
						return exists(root.right, value);
					} else {
						return false;
					}
				}
			}
		} else {
			throw new IllegalArgumentException("tree missing");
		}
	}

}
