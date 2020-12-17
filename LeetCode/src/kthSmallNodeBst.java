import java.util.*;

public class kthSmallNodeBst {

    // O(N)
    int nleft, val;
    public int kthSmallest_v0(TreeNode t, int k) {
        nleft = 0; val = -1;
        kthSmallestRec(t,k);
        return val;
    }
    public int kthSmallestRec(TreeNode t, int k) {
        if(t == null) return -1;

        kthSmallestRec(t.left, k);

        nleft++;
        if(nleft == k) val= t.val;

        kthSmallestRec(t.right, k);

        return -1;
    }

    // O(N) best, O(N^2) worst
    public int kthSmallest_v1(TreeNode t, int k) {
        if(t == null) return -1;

        int nleft = countTree(t.left);
        if(nleft+1 == k) return t.val;
        else if(nleft >= k) return kthSmallest(t.left, k);
        else return kthSmallest(t.right, k-(nleft+1)); // 1 for current node
    }
    int countTree(TreeNode at) {
        return at == null ? 0 : 1+countTree(at.left)+countTree(at.right);
    }

    public int kthSmallest(TreeNode t, int k) {
        var stack = new Stack<TreeNode>();

        while(true) {
            while(t != null) {stack.push(t); t = t.left;}

            t =  stack.pop();
            if(--k == 0) return t.val;

            t = t.right;
        }
    }


    // builing the BST with left count
    class Node {
        int data;
        Node left, right;
        int lCount;
        Node(int x)
        {
            data = x;
            left = right = null;
            lCount = 0;
        }
    }
    public Node insert(Node root, int x)
    {
        if (root == null) return new Node(x);

        if (x < root.data) {
            root.left = insert(root.left, x);
            root.lCount++;
        }
        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }
    public Node kthSmallest(Node root, int k)
    {
        if (root == null) return null;

        int count = root.lCount + 1;
        if (count == k) return root;

        if (count > k) return kthSmallest(root.left, k);

        return kthSmallest(root.right, k - count);
    }

}