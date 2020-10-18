import java.util.*;

public class disKfromAnode {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ArrayList<Integer>[] neigh = new ArrayList[501];
        for (int i = 0; i < 501; neigh[i] = new ArrayList<Integer>(), i++) ;

        dfs(root, null, neigh);

        boolean[] vis = new boolean[501];
        Queue<Integer> q = new LinkedList<>();
        q.add(target.val);
        vis[target.val] = true;

        for (int l = 0; l < K; l++) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int at = q.remove();
                for (int to : neigh[at])
                    if (!vis[to]) {
                        vis[to] = true;
                        q.add(to);
                    }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i : q) res.add(i);

        return res;
    }

    void dfs(TreeNode child, TreeNode parent, ArrayList<Integer>[] neigh)
    {
        if (child == null) return;
        if (child != null && parent != null) {
            neigh[child.val].add(parent.val);
            neigh[parent.val].add(child.val);
        }
        dfs(child.left, child, neigh);
        dfs(child.right, child, neigh);
    }
}