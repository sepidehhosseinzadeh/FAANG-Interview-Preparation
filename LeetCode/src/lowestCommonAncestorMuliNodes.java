import java.util.*;

public class lowestCommonAncestorMuliNodes {
	int cnt;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
		if(root == null) return null;
		cnt = 0;
		var set = new HashSet<TreeNode>();
		set.addAll(Arrays.asList(nodes));
		TreeNode res = lowestCommonAncestor(root, set);
		return cnt == nodes.length ? res : null;
	}
	public TreeNode lowestCommonAncestor(TreeNode root, HashSet<TreeNode> list) {
		if(root == null) return null;

		// this works for if node may not appear in tree
		TreeNode l = lowestCommonAncestor(root.left, list);
		TreeNode r = lowestCommonAncestor(root.right, list);

		if(list.contains(root) || list.contains(root)) {
			cnt++;
			return root;
		}
		if(l != null && r != null) return root;

		return l!= null ? l : r;
	}
}
