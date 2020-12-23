import java.util.*;

public class linkedListZigZag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;

		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);
		int level = 0;
		while(!q.isEmpty()) {
			int nChild = q.size();
			var ret = new ArrayList<Integer>();
			for(int i = 0; i < nChild; i++) {
				TreeNode at = q.poll();
				if(level == 0) ret.add(at.val);
				else ret.add(0, at.val);

				if(at.left != null) q.add(at.left);
				if(at.right != null) q.add(at.right);
			}
			level = 1-level;
			res.add(ret);
		}
		return res;
	}
}