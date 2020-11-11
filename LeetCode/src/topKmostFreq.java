import java.util.*;

public class topKmostFreq {
    public int[] topKFrequent(int[] nums, int k) {
        var freq = new HashMap<Integer, Integer>();
        for (int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);

        var bucket = new ArrayList[nums.length + 1];
        for (int i : freq.keySet()) {
            if (bucket[freq.get(i)] == null)
                bucket[freq.get(i)] = new ArrayList<Integer>();
            bucket[freq.get(i)].add(i);
        }

        int[] res = new int[k];
        for (int i = bucket.length - 1, j = 0; j < k && i >= 0; i--)
            if (bucket[i] != null) {
                for (int z = 0; z < bucket[i].size() && j < k; z++, j++)
                    res[j] = (int) bucket[i].get(z);
            }

        return res;
    }

    // use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
    public List<Integer> topKFrequent_v1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    // use treeMap. Use freqncy as the key so we can get all freqencies in order
    public List<Integer> topKFrequent_v2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}