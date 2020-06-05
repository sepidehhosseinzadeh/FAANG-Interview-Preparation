import java.util.*;

public class LargestDis2nodesTree {
    public class Solution {
        public int solve(int[] arr)
        {
            int n = arr.length;

            ArrayList<Integer>[] neigh = new ArrayList[n];
            for(int i = 0; i < n; i++)
                neigh[i] = new ArrayList<Integer>();

            int root = 0;
            for(int i = 0; i < n; i++)
            {
                if(arr[i] != -1)
                    neigh[arr[i]].add(i);
                else
                    root = i;
            }

            int[] ans = max_dis_bfs(root, neigh);
            int max_dis = ans[0], max_idx = ans[1];

            ans = max_dis_bfs(max_idx, neigh);

            return ans[0];

        }
        public int[] max_dis_bfs(int st, ArrayList<Integer>[] neigh)
        {
            int n = neigh.length;
            if(n == 0)
                return new int[]{0,0};
            int max_dis = 0;
            int max_idx = 0;
            Queue<Integer> q = new LinkedList<Integer>();
            boolean[] visited = new boolean[n];
            int[] dis = new int[n];

            dis[st] = 0;
            q.add(st);
            visited[st] = true;

            while(!q.isEmpty())
            {
                int curr = q.poll();

                for(int to : neigh[curr])
                    if(!visited[to])
                    {
                        visited[to] = true;
                        dis[to] = dis[curr]+1;
                        if(max_dis < dis[curr]+1)
                        {
                            max_dis = dis[curr]+1;
                            max_idx = to;
                        }

                        q.add(to);
                    }
            }
            return new int[] {max_dis, max_idx};

        }
    }

}

