import java.util.*;

public class Dijsktra {
    public class Solution {
        class Node implements Comparable<Node>
        {
            int v, d;
            Node(int v, int d)
            {
                this.v = v;
                this.d = d;
            }
            @Override
            public int compareTo(Node that)
            {
                return this.d - that.d;
            }
        }
        public int[] solve(int n, int[][] B, int src) {
            if(n == 0)
                return new int[n];

            ArrayList<Node>[] neighs = new ArrayList[n];
            for(int i = 0; i < n; i++)
                neighs[i] = new ArrayList<Node>();

            for(int i = 0; i < B.length; i++)
            {
                int at = B[i][0], to = B[i][1], w = B[i][2];
                neighs[at].add(new Node(to, w));
                neighs[to].add(new Node(at, w));
            }

            PriorityQueue<Node> q = new PriorityQueue<Node>();
            boolean[] vis = new boolean[n];
            int[] best = new int[n];
            Arrays.fill(best, Integer.MAX_VALUE);

            Node s = new Node(src, 0);
            best[src] = 0;
            q.add(s);

            while(!q.isEmpty())
            {
                Node at = q.remove();

                if(vis[at.v]) continue;
                vis[at.v] = true;

                for(Node to : neighs[at.v])
                    if(best[to.v] > best[at.v]+to.d)
                    {
                        best[to.v] = best[at.v]+to.d;
                        q.add(new Node(to.v, best[to.v]));
                    }
            }
            for(int i = 0; i < n; i++)
                if(best[i] == Integer.MAX_VALUE)
                    best[i] = -1;
            return best;
        }

    }
}
