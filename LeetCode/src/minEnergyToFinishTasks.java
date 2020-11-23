import java.util.*;

public class minEnergyToFinishTasks {
    // O(nlogn)
    public int minimumEffort_v0(int[][] tasks) {
        Arrays.sort(tasks, (a,b) -> b[1]-b[0]-(a[1]-a[0])); // sort by minEnergy-ConsumedEnergy,
        // because we want to go over tasks which during the process have the most saved energy for next
        int lb = tasks[0][1], ub = 0;
        for(int i = 0; i < tasks.length; i++) ub += tasks[i][1];
        while(lb < ub)
        {
            int mid = lb+(ub-lb)/2;
            if(can(mid, tasks)) ub = mid;
            else lb = mid+1;
        }
        return lb;
    }
    boolean can(int e, int[][] tasks)
    {
        for(int i = 0; i < tasks.length; i++) {
            if(e >= tasks[i][1]) e -= tasks[i][0];
            else return false;
        }
        return true;
    }

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b) -> b[1]-b[0]-(a[1]-a[0]));
        int e = 0; for(int i = 0; i < tasks.length; i++) e += tasks[i][0];
        int res = e;
        for(int i = 0; i < tasks.length; i++)
        {
            if(e < tasks[i][1]) {res += tasks[i][1]-e; e = tasks[i][1];}
            e -= tasks[i][0];
        }
        return res;
    }
}
