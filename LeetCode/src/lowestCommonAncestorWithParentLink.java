import java.util.*;

public class lowestCommonAncestorWithParentLink {
	private class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
	}
	// like LinkedList intersection node
	public Node lowestCommonAncestor_v0(Node p, Node q) {
		Node a = p, b = q;
		while(a != b) {
			a = a==null? q : a.parent;
			b = b==null? p : b.parent;
		}
		return a;
	}

	// move up until one covers the other one
	public Node lowestCommonAncestor(Node p, Node q) {
		if(p == null || q == null) return null;
		if(p == q) return p;
		if(cover(p, q)) return p;
		if(cover(q, p)) return q;

		return lowestCommonAncestor(p.parent, q.parent);
	}
	boolean cover(Node p, Node q) {
		if(p == null) return false;
		if(p == q) return true;
		return cover(p.left, q) || cover(p.right, q);
	}
}
