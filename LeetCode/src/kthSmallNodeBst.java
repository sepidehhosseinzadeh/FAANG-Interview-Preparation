import java.util.*;

public class kthSmallNodeBst {
    // O(N) best, O(N^2) worst
    int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        }
        else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    private static int number = 0;
    private static int count = 0;

    // O(N)
    public int kthSmallest_v1(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }

    public int kthSmallest_v3(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
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
        if (root == null)
            return null;

        int count = root.lCount + 1;
        if (count == k)
            return root;

        if (count > k)
            return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - count);
    }

}