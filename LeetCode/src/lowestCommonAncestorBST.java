import java.util.*;

public class lowestCommonAncestorBST {
	public TreeNode lowestCommonAncestor_v0(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;

		if(root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left,p,q);
		else if(root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right,p,q);
		return root; // lowest p < root < q
	}
	// itertative
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode at = root;

		while (at != null) {
			if(at.val < p.val && at.val < q.val) at = at.right;
			else if(at.val > p.val && at.val > q.val) at = at.left;
			else return at;
		}
		return null;
	}
}
