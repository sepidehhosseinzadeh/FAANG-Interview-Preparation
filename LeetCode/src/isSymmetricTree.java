import java.util.*;

public class isSymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return root == null || isSymmetric(root.left, root.right);
	}
	boolean isSymmetric(TreeNode l, TreeNode r) {
		if(l == null && r == null) return true;
		if(l == null || r == null) return false;
		return l.val == r.val &&
				isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
	}
	public boolean isSymmetric_v1(TreeNode root) {
		if (root == null) return true;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);
		while (!stack.empty()) {
			TreeNode n1 = stack.pop(), n2 = stack.pop();
			if (n1 == null && n2 == null) continue;
			if (n1 == null || n2 == null || n1.val != n2.val) return false;
			stack.push(n1.left);
			stack.push(n2.right);
			stack.push(n1.right);
			stack.push(n2.left);
		}
		return true;
	}
}
