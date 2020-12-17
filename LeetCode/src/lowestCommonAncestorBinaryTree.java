import java.util.*;

public class lowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		if(root == p || root == q) return root;

		TreeNode l = lowestCommonAncestor(root.left,p,q);
		TreeNode r = lowestCommonAncestor(root.right,p,q);
		if(l!=null && r!=null) return root;

		return l!=null ? l : r!=null ? r : null;
	}
}
