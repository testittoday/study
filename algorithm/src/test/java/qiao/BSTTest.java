package qiao;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {

	@Test
	public void testSortedArrayToBST() {
		int[] a = { 3, 5, 8 };
		print(BST.sortedArrayToBST(a));
	}

	private void print(TreeNode node) {
		if (node != null) {
			System.out.print(node.val);
			System.out.print("-->");
			print(node.left);
			System.out.print(node.val);
			System.out.print("-->");
			print(node.right);
		} else {
			System.out.println(";");
		}

	}
}
