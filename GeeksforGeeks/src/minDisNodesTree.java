import java.util.*;

public class minDisNodesTree {
    public static void main(String[] args)
    {
    }
}
class GfG {
    static class Node
    {
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    }
    HashMap<Node, Node> par;
    GfG() {par = new HashMap<>();}
    int findDist(Node root, int a, int b) {
        if(root == null) return -1;
        if(a == b) return 0;
        dfs(root, null);

        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> vis = new ArrayList<>();
        q.add(root);

        int d = -1;
        while(!q.isEmpty())
        {
            int n = q.size();
            if(d >= 0) d++;
            for(int i = 0; i < n; i++)
            {
                Node at = q.remove();
                if(vis.contains(at)) continue;

                if(at.data == a || at.data == b) d = 0;
                if((at.data == a || at.data == b) && d > 0) return d;

                if(at.left != null) q.add(at.left);
                if(at.right != null) q.add(at.right);
                if(par.containsKey(at)) q.add(par.get(at));
                if(d >= 0) vis.add(at);
            }
        }
        return -1;
    }
    void dfs(Node at, Node p)
    {
        if(at == null) return;
        if(p != null) par.put(at, p);
        dfs(at.left, at);
        dfs(at.right, at);
    }
}
