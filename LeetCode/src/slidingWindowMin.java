import java.util.*;

public class slidingWindowMin {
    public static void main(String[] args)
    {
    }

    public int[] mostCompetitive(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((i,j) -> i[0]!=j[0] ? i[0]-j[0] : i[1]-j[1]);
        for(int j = 0; j <= nums.length-k; j++) q.add(new int[]{nums[j],j});
        int[] res = new int[k];
        int i = 0;

        int preIdx = -1;
        while(k > 0)
        {
            int[] min = q.poll();
            if(preIdx != -1)
                while(min[1] < preIdx)
                    min = q.poll();

            res[i++] = min[0];
            preIdx = min[1];
            k--;
            if(k > 0)
                q.add(new int[]{nums[nums.length-k], nums.length-k});
        }
        return res;
    }

    public int[] mostCompetitive_(int[] nums, int k) {
        int[] res = new int[k];
        int i = 0;
        int pre = -1;
        while(k > 0)
        {
            int min = Integer.MAX_VALUE;
            for(int j = pre+1; j <= nums.length-k; j++)
                if(min > nums[j]) {
                    min = nums[j];
                    pre = j;
                }

            res[i++] = min;
            k--;
        }
        return res;
    }
}

