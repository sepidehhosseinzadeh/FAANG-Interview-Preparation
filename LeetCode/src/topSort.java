import javax.naming.MalformedLinkException;
import java.util.*;

public class topSort {
    public static void main(String[] args)
    {
        System.out.print(canFinish(4, new int[][]{{2,0},{1,0},{3,1},{3,2},{1,3}}));
    }

    public static boolean canFinish(int n, int[][] edges) {
        int m = edges.length;
        ArrayList<Integer>[] neigh = new ArrayList[n];
        for (int i = 0; i < n; neigh[i] = new ArrayList<>(), i++) ;
        for (int i = 0; i < m; i++)
            neigh[edges[i][0]].add(edges[i][1]);

        boolean all = true;
        for(int i = 0; i < n; i++)
            all &= topSort(i, new int[n], neigh);
        return all;
    }

    static boolean topSort(int at, int[] vis, ArrayList<Integer>[] neigh)
    {
        vis[at] = 1;

        for (int to : neigh[at]) {
            if (vis[to] == 0)
                if (!topSort(to, vis, neigh)) return false;
            if (vis[to] == 1)
                    return false;
        }

        vis[at] = 2;
        return true;

    }
}

