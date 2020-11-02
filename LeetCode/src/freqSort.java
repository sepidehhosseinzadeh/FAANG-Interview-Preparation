import java.util.*;

public class freqSort {
    public int[] frequencySort(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int v : nums)
            map.put(v, map.getOrDefault(v, 0) + 1);

        var list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, (i, j) -> i.getValue() != j.getValue() ? i.getValue() - j.getValue() : j.getKey() - i.getKey());

        int k = 0;
        for (Map.Entry<Integer, Integer> v : list)
            for (int i = 0; i < v.getValue(); i++)
                nums[k++] = v.getKey();

        return nums;
    }

    public int[] frequencySort_v1(int[] nums) {
        var freq = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freq.put(n, 1 + freq.getOrDefault(n, 0));
        }
        var pq = new PriorityQueue<Integer>((i, j) -> freq.get(i) == freq.get(j) ? j - i : freq.get(i) - freq.get(j));
        for (int n : nums) {
            pq.offer(n);
        }
        int i = 0;
        int[] ans = new int[nums.length];
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }

    public int[] frequencySort_v2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();//map to store count of each number
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else {
                list.add(num);
                map.put(num, 1);
            }
        }
        Collections.sort(list, (a, b) -> map.get(a) == map.get(b) ? (b - a) : map.get(a) - map.get(b));//sorting based on count value first and then number value
        int arr[] = new int[nums.length];
        int k = 0;
        for (int num : list) {
            int cnt = map.get(num);
            while (cnt > 0) {
                arr[k++] = num;
                cnt--;
            }
        }
        return arr;
    }
}
