import java.util.*;

public class maxPlatformTrain {
    static int findPlatform(int arr[], int dep[], int n)
    {
        var t = new PriorityQueue<int[]>((i,j)->i[0]!=j[0]?i[0]-j[0]:j[1]-i[1]);
        for(int i = 0; i < n; i++) {
            t.add(new int[]{arr[i],1});
            t.add(new int[]{dep[i],-1});
        }

        int max = 0, cnt = 0;
        while(!t.isEmpty()) {
            int[] val = t.poll();
            cnt += val[1];
            max = Math.max(max, cnt);
        }
        return max;
    }
    static int findPlatform_v1(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
            result = Math.max(result, plat_needed);
        }

        return result;
    }
}

