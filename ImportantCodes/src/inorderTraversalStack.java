import java.util.*;

public class inorderTraversalStack {
	class TreeNode {
		int val;
		TreeNode left, right;
	}
	ArrayList<Integer> inorderTraversal(TreeNode root) {
		var inorder = new ArrayList<Integer>();
		var nodes = new Stack<TreeNode>();

		if(root == null) return inorder;

		while(root != null || !nodes.isEmpty()) {
			//push left children if available
			while(root != null) {
				nodes.push(root);
				root = root.left;
			}

			//retrieve top node and store its right child if exists
			root = nodes.pop();
			inorder.add(root.val);

			root = root.right;
		}

		return inorder;
	}
}
