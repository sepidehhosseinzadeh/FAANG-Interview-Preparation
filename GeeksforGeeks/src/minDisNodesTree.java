import java.util.*;

public class minDisNodesTree {
    static ArrayList<Integer>[] neigh;
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = "
                + findDist(root, 4, 5));

        System.out.println("Dist(4, 6) = "
                + findDist(root, 4, 6));

        System.out.println("Dist(3, 4) = "
                + findDist(root, 3, 4));

        System.out.println("Dist(2, 4) = "
                + findDist(root, 2, 4));

        System.out.println("Dist(8, 5) = "
                + findDist(root, 8, 5));

    }
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    static int findDist_v0(Node root, int a, int b) {
        if (root == null) return -1;
        neigh = new ArrayList[(int) 1e5 + 1];
        for(int i = 0; i< 1e5+1;neigh[i]=new ArrayList<>(),i++);

        dfs(root, null);

        return bfs(a, b);
    }
    static void dfs(Node at, Node p)
    {
        if (at == null) return;

        if (p != null) {
            neigh[at.data].add(p.data);
            neigh[p.data].add(at.data);
        }

        dfs(at.left, at);
        dfs(at.right, at);
    }
    static int bfs(int a, int b)
    {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> vis = new ArrayList<>();
        q.add(a);
        vis.add(a);

        for (int d = 0; d < 1e4 + 1 && !q.isEmpty(); d++) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int at = q.remove();

                if (at == b) return d;

                for (int to : neigh[at])
                    if (!vis.contains(to)) {
                        vis.add(to);
                        q.add(to);
                    }
            }
        }

        return -1;
    }

    // Second approach: using lowest common ancestor (lca)
    static int findDist(Node root, int a, int b)
    {
        Node lca = lca(root, a, b);
        int da = dist(lca, a);
        int db = dist(lca, b);
        if(da < 0 || db < 0) return -1;
        return da+db;
    }
    static Node lca(Node root, int a, int b)
    {
        if(root == null)    return null;
        if(root.data == a)   return root;
        if(root.data == b)   return root;

        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);

        if(left != null && right != null)
            return root;

        return left != null ? left : right;
    }
    static int dist(Node root, int val)
    {
        if(root == null) return Integer.MIN_VALUE;
        if(root.data == val) return 0;

        int dl = 1+dist(root.left, val);
        if(dl >= 0) return dl;

        int dr = 1+dist(root.right, val);
        if(dr >= 0) return dr;

        return Integer.MIN_VALUE;
    }

}
