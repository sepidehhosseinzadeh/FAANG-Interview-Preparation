import java.util.*;

public class validBST {
	// This code doesn't work for values with Integer.MIN_VALUE/MAX...
	public boolean isValidBST_v0(TreeNode root) {
		return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	boolean valid(TreeNode at, long lb, long ub) {
		if(at == null) return true;

		return lb < at.val && at.val < ub &&
				valid(at.left, lb, at.val) && valid(at.right, at.val, ub);
	}


	public boolean isValidBST_v1(TreeNode root) {
		return validate(root, null, null);
	}
	public boolean validate(TreeNode root, Integer low, Integer high) {
		if (root == null) return true;

		if ((low != null && root.val <= low) || (high != null && root.val >= high))
			return false;

		return validate(root.right, root.val, high) && validate(root.left, low, root.val);
	}


	// itertative
	private Deque<TreeNode> stack = new LinkedList();
	private Deque<Integer> upperLimits = new LinkedList();
	private Deque<Integer> lowerLimits = new LinkedList();

	public void update(TreeNode root, Integer low, Integer high) {
		stack.add(root);
		lowerLimits.add(low);
		upperLimits.add(high);
	}

	public boolean isValidBST_v2(TreeNode root) {
		Integer low = null, high = null, val;
		update(root, low, high);

		while (!stack.isEmpty()) {
			root = stack.poll();
			low = lowerLimits.poll();
			high = upperLimits.poll();

			if (root == null) continue;
			val = root.val;
			if (low != null && val <= low) {
				return false;
			}
			if (high != null && val >= high) {
				return false;
			}
			update(root.right, val, high);
			update(root.left, low, val);
		}
		return true;
	}

	private Integer prev;
	public boolean isValidBST_v3(TreeNode root) {
		prev = null;
		return inorder(root);
	}

	private boolean inorder(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!inorder(root.left)) {
			return false;
		}
		if (prev != null && root.val <= prev) {
			return false;
		}
		prev = root.val;
		return inorder(root.right);
	}

	public boolean isValidBST(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		Integer prev = null;

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			// If next element in inorder traversal
			// is smaller than the previous one
			// that's not BST.
			if (prev != null && root.val <= prev) {
				return false;
			}
			prev = root.val;
			root = root.right;
		}
		return true;
	}
}