import java.util.*;

public class insertDelRandO1 {
	class RandomizedSet {
		int n;
		HashMap<Integer, Integer> idx, val;
		/** Initialize your data structure here. */
		public RandomizedSet() {
			idx = new HashMap<>();
			val = new HashMap<>();
			n = 0;
		}

		/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
		public boolean insert(int v) {
			if(idx.containsKey(v)) return false;
			val.put(n, v);
			idx.put(v, n);
			n++;
			return true;
		}

		/** Removes a value from the set. Returns true if the set contained the specified element. */
		public boolean remove(int v) {
			if(!idx.containsKey(v)) return false;
			int i = idx.get(v);
			if(i != n-1) { // swap i with last one
				int lastVal = val.get(n-1);
				idx.put(lastVal, i);
				idx.put(v, n-1);
				val.put(i, lastVal);
				val.put(n-1, v);
			}
			idx.remove(v);
			val.remove(n-1);
			n--;
			return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			Random r = new Random();
			return val.get(r.nextInt(n));
		}
	}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
