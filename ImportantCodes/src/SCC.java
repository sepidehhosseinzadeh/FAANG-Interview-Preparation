// algorithm to print all SCCs
import java.util.*;

class SCC {
    static class Graph
    {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void DFSUtil(int v, boolean visited[])
        {
            visited[v] = true;
            System.out.print(v + " ");

            int n;

            Iterator<Integer> i = adj[v].iterator();
            while (i.hasNext()) {
                n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        Graph getTranspose()
        {
            Graph g = new Graph(V);
            for (int v = 0; v < V; v++) {
                Iterator<Integer> i = adj[v].listIterator();
                while (i.hasNext())
                    g.adj[i.next()].add(v);
            }
            return g;
        }

        void fillOrder(int v, boolean visited[], Stack stack)
        {
            visited[v] = true;

            Iterator<Integer> i = adj[v].iterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    fillOrder(n, visited, stack);
            }

            stack.push(v);
        }

        void printSCCs()
        {
            Stack stack = new Stack();

            boolean visited[] = new boolean[V];

            // Fill vertices in stack according to their finishing time
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    fillOrder(i, visited, stack);

            Graph gr = getTranspose();

            // Mark all the vertices as not visited (For second DFS)
            visited = new boolean[V];

            // Now process all vertices in order defined by Stack
            while (stack.empty() == false) {
                int v = (int) stack.pop();

                // Print SCC of the popped vertex
                if (visited[v] == false) {
                    gr.DFSUtil(v, visited);
                    System.out.println();
                }
            }
        }
    }
}
