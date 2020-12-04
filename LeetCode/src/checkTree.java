import java.util.*;

public class checkTree {
    // union find
    public boolean validTree(int n, int[][] e) {
        int[] label = new int[n];
        for(int i = 0; i < n; label[i] = i, i++);

        for(int i = 0; i < e.length; i++) {
            int l1 = find(label, e[i][0]);
            int l2 = find(label, e[i][1]);

            if(l1 == l2) // same component
                return false;

            label[l2] = l1; // union the roots of two nodes connected by edge
        }

        return e.length == n-1;
    }
    int find(int[] label, int v) { // find root label
        if(label[v] != v)
            return label[v] = find(label, label[v]);
        return v;
    }

    // dfs
    public boolean validTree_v0(int n, int[][] e) {
        var neigh = new ArrayList[n];

        for(int i = 0; i < n; neigh[i] = new ArrayList<Integer>(), i++);
        for(int i = 0; i < e.length; i++) {
            neigh[e[i][0]].add(e[i][1]);
            neigh[e[i][1]].add(e[i][0]);
        }

        int[] vis = new int[n];

        int cc = 0;
        for(int i = 0; i < n; i++)
            if(vis[i] == 0) {
                cc++;
                if(!dfs(-1,i,neigh,vis)) return false;
            } else if(cc > 1) return false;

        return e.length == n-1;
    }
    boolean dfs(int parent, int at, ArrayList<Integer>[] neigh, int[] vis) {
        vis[at] = 1;

        for(int to : neigh[at]) {
            if(vis[to] == 1 && parent != to) return false; // loop
            if(vis[to] == 0) {
                vis[to] = 1;
                if(!dfs(at,to, neigh, vis)) return false;
            }
        }

        vis[at] = 2;
        return true;
    }
}
