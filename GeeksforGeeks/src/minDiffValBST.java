import java.util.*;

public class minDiffValBST {
    static int minDiff(Node root, int x)
    {
        if(root == null) return Integer.MAX_VALUE;
        if(root.data == x) return 0;
        if(root.data > x) return Math.min(Math.abs(root.data-x),
                minDiff(root.left, x));
        return Math.min(Math.abs(root.data-x),
                minDiff(root.right, x));
    }
    static class Node {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }
}
