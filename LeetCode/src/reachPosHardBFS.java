import java.util.*;

public class reachPosHardBFS {
    // https://leetcode.com/problems/minimum-jumps-to-reach-home/
    // understanding at most you can visit 4 times
    // 4*2000
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        var forbid = new HashSet<Integer>();
        for(int i : forbidden) forbid.add(i);

        var visited = new int[2*2000];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0); // at
        q.add(0); // #jumps
        q.add(0); // isBackward

        while(!q.isEmpty())
        {
            int at = q.remove();
            int j = q.remove();
            int isback = q.remove();

            if(at == x) return j;

            if(at+a < 2*2000 && !forbid.contains(at+a) && visited[at+a] < 4)
                {q.add(at+a); q.add(j+1); q.add(0); visited[at+a]++;}
            if(isback == 0 && at >= b && !forbid.contains(at-b) && visited[at-b] < 4)
                {q.add(at-b); q.add(j+1); q.add(1); visited[at-b]++;}
        }

        return -1;
    }

}