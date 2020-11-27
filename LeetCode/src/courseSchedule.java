import java.util.*;

public class courseSchedule {
    public boolean canFinish_v0(int numCourses, int[][] prerequisites) {
        int[] flag = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            if(!dfs(i, prerequisites, flag)) return false;
        return true;
    }
    boolean dfs(int at, int[][] neigh, int[] flag)
    {
        if(flag[at] == 2) return true;

        for(int i = 0; i < neigh.length; i++)
            if(neigh[i][0] == at)
            {
                int to = neigh[i][1];
                if(flag[to] == 1) return false;
                flag[to] = 1;
                if(!dfs(to, neigh, flag)) return false;
            }

        flag[at] = 2;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] pre) {
        int[] degree = new int[numCourses];
        ArrayList<Integer>[] neigh = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            neigh[i] = new ArrayList<Integer>();

        for(int i = 0; i < pre.length; i++)
        {
            neigh[pre[i][1]].add(pre[i][0]); // first need to take 1, then 0
            degree[pre[i][0]]++;
        }

        var finished = new ArrayList<Integer>();
        for(int i = 0; i < numCourses; i++)
            if(degree[i] == 0) finished.add(i);

        for(int i = 0; i < finished.size(); i++)
            for(int to : neigh[finished.get(i)]) // if finish, add it, and --degree
                if(--degree[to] == 0)	finished.add(to);

        return finished.size() == numCourses;
    }
}
