package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeFromInAndPostTraversalTest {

	@Test
	public void test() {
		TreeNode tree = BinaryTreeFromInAndPostTraversal.buildTree(new int[] {
				2, 1, 3 }, new int[] { 2, 3, 1 });
		printTreeInOrder(tree);
		System.out.println("*****");
		tree = BinaryTreeFromInAndPostTraversal.buildTree(
				new int[] { 3, 2, 1 }, new int[] { 3, 2, 1 });
		printTreeInOrder(tree);

	}

	private void printTreeInOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		printTreeInOrder(root.left);
		System.out.println(root.val);
		printTreeInOrder(root.right);
	}

}
