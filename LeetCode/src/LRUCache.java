import java.util.*;

public class LRUCache {
    HashMap<Integer, Integer> map;
    Queue<Integer> q;
    int cap;

    LRUCache(int cap)
    {
        map = new HashMap<>();
        q = new LinkedList<>();
        this.cap = cap;
    }

    public int get(int key)
    {
        if (map.containsKey(key)) {
            q.remove(key);
            q.offer(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value)
    {
        if (map.containsKey(key)) {
            map.remove(key);
            q.remove(key);
        }
        else if (map.size() == cap)
            map.remove(q.poll());

        map.put(key, value);
        q.offer(key);
    }


    class LRUCache1 {
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        int cap = 0;

        public LRUCache1(int capacity) {
            cap = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                int value = cache.get(key);
                cache.remove(key);
                cache.put(key, value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key);
                cache.put(key, value);
            }
            else if (cache.size() == cap)
                cache.remove(cache.entrySet().iterator().next().getKey());

            cache.put(key, value);
        }
    }
}
