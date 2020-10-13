import java.util.*;

// Node at distance
// Given a Binary Tree and a positive integer k.
// Count all distinct nodes that are distance k from a leaf node

public class LeafsAtKNodes {

    static class Node {
        int data;
        Node left, right;
        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    int cnt;
    int printKDistantfromLeaf(Node root, int k)
    {
        cnt = 0;
        level(root, k, 0, new int[1000], new boolean[1000]);
        return cnt;
    }

    void level(Node t, int k, int l, int[] path, boolean[] visited)
    {
        if (t == null) return;

        path[l] = t.data;
        visited[l] = false;

        level(t.left, k, l + 1, path, visited);
        level(t.right, k, l + 1, path, visited);

        if (t.left == null && t.right == null && l - k >= 0 &&
                !visited[l - k])
        {
            //System.out.print(path[l-k-1]+" ");
            visited[l - k] = true;
            cnt++;
            return;
        }
    }
}
