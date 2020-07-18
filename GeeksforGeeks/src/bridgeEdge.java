import java.util.*;

public class bridgeEdge {
    class Graph
    {
        private int V;
        private LinkedList<Integer> adj[];
        int time = 0;
        static final int NIL = -1;

        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w)
        {
            adj[v].add(w);
            adj[w].add(v);
        }
        void bridgeUtil(int u, boolean visited[], int disc[],
                        int low[], int parent[])
        {
            visited[u] = true;

            // Init discovery time and low value
            disc[u] = low[u] = ++time;

            Iterator<Integer> i = adj[u].iterator();
            while (i.hasNext())
            {
                int v = i.next();

                if (!visited[v])
                {
                    parent[v] = u;
                    bridgeUtil(v, visited, disc, low, parent);

                    // Check if the subtree rooted with v has a
                    // connection to one of the ancestors of u
                    low[u] = Math.min(low[u], low[v]);

                    // If the lowest vertex reachable from subtree
                    // under v is below u in DFS tree, then u-v is
                    // a bridge
                    if (low[v] > disc[u])
                        System.out.println(u+" "+v);
                }

                // Update low value of u for parent function calls.
                else if (v != parent[u])
                    low[u] = Math.min(low[u], disc[v]);
            }
        }

        void bridge()
        {
            boolean visited[] = new boolean[V];
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];

            Arrays.fill(parent, NIL);

            for (int i = 0; i < V; i++)
                if (!visited[i])
                    bridgeUtil(i, visited, disc, low, parent);
        }
    }
}
