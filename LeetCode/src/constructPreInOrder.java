import java.util.*;

public class constructPreInOrder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		if(n == 0) return null;
		return build(0, n-1, 0, n-1, preorder, inorder);
	}
	TreeNode build(int l1, int r1, int l2, int r2, int[] pre, int[] in) {
		if(l1 == r1) return new TreeNode(pre[l1]);
		if(r1 > l1) return null;

		TreeNode root = new TreeNode(pre[l1]);
		int i = findIdx(pre[l1], in);
		int len = i-l2;
		root.left = build(l1+1, l1+len, l2, i-1, pre,in);
		root.right = build(l1+len+1, r1, i+1, r2, pre,in);

		return root;
	}
	int findIdx(int val, int[] arr) {
		for(int i = 0; i < arr.length; i++)
			if(val == arr[i]) return i;
		return -1;
	}
}