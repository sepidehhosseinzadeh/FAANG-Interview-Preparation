import java.util.*;

//  Longest Continuous Subarray With Absolute Diff <= Limit
public class longSubArrDifflimit {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            final int n = sc.nextInt(), limit = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(longestSubarray(arr, limit));
            System.out.println("dequeue: ");
            System.out.println(longestSubarray_v1(arr, limit));
        }
    }

    // O(nlogn)
    static int longestSubarray_v1(int[] num, int limit)
    {
        int maxlen = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0, j = 0; j < num.length; j++) {
            map.put(num[j], map.getOrDefault(num[j], 0) + 1);
            if (!map.isEmpty() && map.lastKey() - map.firstKey() > limit) {
                map.put(num[i], map.get(num[i]) - 1);
                if (map.get(num[i]) == 0) map.remove(num[i]);
                i++;
            }
            maxlen = Math.max(maxlen, j - i + 1);

        }
        return maxlen;
    }
    // O(n)
    static int longestSubarray(int[] num, int limit)
    {
        int maxlen = 0;
        Deque<Integer> mind = new LinkedList<>();
        Deque<Integer> maxd = new LinkedList<>();

        for (int i = 0, j = 0; j < num.length; j++) {
            while (!mind.isEmpty() && mind.peekLast() > num[j])
                mind.pollLast();
            mind.addLast(num[j]);

            while (!maxd.isEmpty() && maxd.peekLast() < num[j])
                maxd.pollLast();
            maxd.addLast(num[j]);

            if (maxd.peekFirst() - mind.peekFirst() > limit) {
                if (num[i] == mind.peekFirst()) mind.pollFirst();
                if (num[i] == maxd.peekFirst()) maxd.pollFirst();
                i++;
            }
            maxlen = Math.max(maxlen, j - i + 1);
        }
        return maxlen;
    }
}
