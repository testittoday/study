package qiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**

 * @author liqiao
 *
 */
public class PathSum {
	
	/**
	 * 
	 *  * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 * 
	 * Accepted by the Online Judge
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return hasPathSum(root, sum, 0);
	}

	private boolean hasPathSum(TreeNode root, int expectedSum, int actualSum) {
		if (root.left == null && root.right == null) {
			return expectedSum == actualSum + root.val;
		} else {
			boolean hasPath = false;
			if (root.left != null) {
				hasPath = hasPathSum(root.left, expectedSum, actualSum
						+ root.val);
			}
			if (!hasPath && root.right != null) {
				hasPath = hasPathSum(root.right, expectedSum, actualSum
						+ root.val);
			}
			return hasPath;
		}
	}
	
	
	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
	 * 
	 * Accepted by the Online Judge
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return Collections.emptyList();
        }else{
            Stack<Integer> currentPath = new Stack<Integer>();
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            findPathSum(root, sum, 0, currentPath, result);
            return result;            
        }
    }
    
    private void findPathSum(TreeNode root, int expectedSum, int actualSum, Stack<Integer> currentPath, List<List<Integer>> result){
        currentPath.push(root.val);
        if(root.left==null && root.right==null){
            if(expectedSum == actualSum+root.val){
                List<Integer> rightPath = new ArrayList<Integer>(currentPath);
                result.add(rightPath);
            }
        }else{
            if(root.left!=null){
                findPathSum(root.left, expectedSum, actualSum+root.val, currentPath, result);
            }
            if(root.right!=null){
                findPathSum(root.right, expectedSum, actualSum+root.val, currentPath, result);
            }
        }
        currentPath.pop();
    }
}
