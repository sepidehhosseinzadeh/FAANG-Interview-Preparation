import java.util.ArrayList;

public class ToplogicalSort {
    public class Solution {
        public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
            ArrayList<Integer>[] neigh = new ArrayList[A+1];
            for(int i = 0; i <= A; i++)
                neigh[i] = new ArrayList<Integer>();

            if(B.size() > 1)
                for(int i = 0; i < B.size(); i++)
                    neigh[B.get(i)].add(C.get(i));

            int[] visited = new int[A+1];
            //for(int i = 1; i < A+1; i++)
            //if(visited[i] == 0)
            {
                visited[1] = 1;
                if(!dfs(1, neigh, visited))
                    return 0;
            }

            return 1;
        }
        boolean dfs(int at, ArrayList<Integer>[] neigh, int[] visited)
        {
            for(int to : neigh[at])
                if(visited[to] == 0)
                {
                    visited[to] = 1;
                    if(!dfs(to, neigh, visited))
                        return false;
                }
                else if(visited[to] == 1)
                    return false;

            visited[at] = 2;
            return true;
        }
    }

}
