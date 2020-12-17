import java.util.*;

public class lowestCommonAncestorBinaryTreeMaybeNotFound {
	int cnt;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		cnt = 0;
		TreeNode res = LCA(root, p,q);
		return cnt == 2 ? res : null;
	}
	private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		// if(root == p || root == q) {cnt++; return root;} // WRONG!!! if it's here, will stop if found one!!!

		TreeNode l = LCA(root.left, p, q);
		TreeNode r = LCA(root.right,p, q);
		if(root == p || root == q) {cnt++; return root;}

		if(l != null && r != null) return root;

		return l != null ? l : r;
	}

	boolean pMark, qMark;
	public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
		pMark = false; qMark = false;
		TreeNode res = LCA(root, p,q);
		return pMark && qMark ? res : null;
	}
	private TreeNode LCA_(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		// WRONG!!! if it's here, will stop if found one!!!
		// if(root == p) {pMark = true; return root;}
		// if(root == q) {qMark = true; return root;}

		TreeNode l = LCA(root.left, p, q);
		TreeNode r = LCA(root.right,p, q);

		if(root == p) {pMark = true; return root;}
		if(root == q) {qMark = true; return root;}

		if(l != null && r != null) return root;

		return l != null ? l : r;
	}
}
