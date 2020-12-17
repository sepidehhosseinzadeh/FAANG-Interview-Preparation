import java.util.*;

public class maxSumTree {
	int maxSum;
	int MIN = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxSum = MIN;
		maxPathSumFromRoot(root);
		return maxSum;
	}
	int maxPathSumFromRoot(TreeNode root) {
		if(root == null) return MIN;

		int left = Math.max(0, maxPathSumFromRoot(root.left));
		int right = Math.max(0,maxPathSumFromRoot(root.right));

		maxSum = Math.max(maxSum, left+root.val+right);

		return root.val+Math.max(left, right);
	}
}
