import java.util.*;

public class hashMapClass {
	class MyHashMap_v0 {
		int N = 1000000+1;
		int[] values;

		/** Initialize your data structure here. */
		public MyHashMap_v0() {
			values = new int[N];
			Arrays.fill(values, -1);
		}

		/** value will always be non-negative. */
		public void put(int key, int value) {
			values[key] = value;
		}

		/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
		public int get(int key) {
			return values[key];
		}

		/** Removes the mapping of the specified value key if this map contains a mapping for the key */
		public void remove(int key) {
			values[key] = -1;
		}
	}

	class Node {
		int key, value;
		Node next = null;
		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	class MyHashMap {
		int MOD = 10007;
		Node[] bucket;

		public MyHashMap() {
			bucket = new Node[MOD];
		}

		private int index(int key) {
			return Integer.hashCode(key)%MOD;
		}
		private Node getPreNode(Node head, int key) {
			Node t = head;
			while(t != null && !(t.next == null || t.next.key == key))
				t = t.next;
			return t;
		}

		/** value will always be non-negative. */
		public void put(int key, int value) {
			int idx = index(key);
			if(bucket[idx] == null) bucket[idx] = new Node(-1,-1);
			Node pre = getPreNode(bucket[idx], key);
			if(pre.next == null) {
				pre.next = new Node(key, value);
			} else pre.next.value = value;
		}

		/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
		public int get(int key) {
			int idx = index(key);
			Node pre = getPreNode(bucket[idx], key);
			return (pre == null || pre.next == null) ? -1 : pre.next.value;
		}

		/** Removes the mapping of the specified value key if this map contains a mapping for the key */
		public void remove(int key) {
			int idx = index(key);
			Node pre = getPreNode(bucket[idx], key);
			if(pre != null && pre.next != null)
				pre.next = pre.next.next;
		}
	}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}