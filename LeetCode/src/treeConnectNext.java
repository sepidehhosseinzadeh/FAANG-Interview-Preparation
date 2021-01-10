import java.util.*;

public class treeConnectNext {

// Definition for a Node.
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left,
					Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}


	public Node connect_v0(Node root) {
		if(root == null) return null;

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int nChild = q.size();
			for(int i = 0; i < nChild; i++) {
				Node at = q.poll();
				if(i < nChild-1) at.next = q.peek();

				if(at.left != null) q.add(at.left);
				if(at.right != null) q.add(at.right);
			}
		}
		return root;
	}
	// recursive
	public Node connect(Node root) {
		connectRec(root);
		return root;
	}
	public void connectRec(Node root) {
		if(root == null || root.left == null) return;
		root.left.next = root.right;
		if(root.next != null) root.right.next = root.next.left;

		connect(root.left);
		connect(root.right);
	}
}
