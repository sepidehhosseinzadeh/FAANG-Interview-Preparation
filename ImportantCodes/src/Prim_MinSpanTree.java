import java.util.*;

public class Prim_MinSpanTree {
    public class Solution {
        class Node implements Comparable<Node>
        {
            int at, to, w;
            Node(int at, int to, int w)
            {
                this.at = at;
                this.to = to;
                this.w = w;
            }
            @Override
            public int compareTo(Node that)
            {
                return this.w-that.w;
            }
        }
        public int solve(int n, int[][] B) {

            int cost = 0;
            ArrayList<Node>[] neigh = new ArrayList[n];
            for(int i = 0; i < n; i++)
                neigh[i] = new ArrayList<Node>();

            for(int i = 0; i < B.length; i++)
            {
                neigh[B[i][0]-1].add(new Node(B[i][0]-1, B[i][1]-1, B[i][2]));
                neigh[B[i][1]-1].add(new Node(B[i][1]-1, B[i][0]-1, B[i][2]));
            }

            PriorityQueue<Node> q = new PriorityQueue<Node>();
            boolean[] vis = new boolean[n];
            for(Node i : neigh[0])
                q.add(i);
            vis[0] = true;

            while(!q.isEmpty())
            {
                Node at = q.remove();

                if(vis[at.to])  continue;
                vis[at.to] = true;

                cost += at.w;

                for(Node to : neigh[at.to])
                    q.add(to);
            }
            return cost;

        }
    }

}
