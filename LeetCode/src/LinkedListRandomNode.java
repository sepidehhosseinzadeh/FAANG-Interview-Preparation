import java.util.*;

public class LinkedListRandomNode {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {

		ListNode head;
		/** @param head The linked list's head.
		Note that the head is guaranteed to be not null, so it contains at least one node. */
		public Solution(ListNode head) {
			this.head = head;
		}

		// random.nextInt(n) : rand num between [0, n) n excl
		public int getRandom() {
			Random r = new Random();
			int i = 0, chosen = head.val;

			for(ListNode t = head; t != null; t=t.next, i++)
				if(r.nextInt(i+1) == i) chosen = t.val;

			return chosen;
		}
		/** Returns a random node's value. */
		public int getRandom_v0() {
			int scope = 1, chosenValue = 0;
			ListNode curr = this.head;
			while (curr != null) {
				// Note: each ith iteration I'm choosing if I should
				// replace current one I have or not. We iterate till the end.
				// P(chosen/replace) = 1/i, P(not chosen) = 1-1/i=i-1/i.
				// P(ith end up till the end) = i/i+1 x i+1/i+2 x .. n-1/n = 1/n.
				// so P of each item is equal.

				if (Math.random() < 1.0 / scope)
					chosenValue = curr.val;
				// move on to the next node
				scope += 1;
				curr = curr.next;
			}
			return chosenValue;
		}
		public int getRandom_wrong() {
			ListNode t = head;
			int len = 1, chosen = 0;
			while (t != null) {
				if (Math.random() < 1.0 / len)
					return t.val; // is wrong!!!!!
				// becuz we need to go through all elements,
				// to have 1/n probability for choosing each node
				t = t.next;
				len++;
			}
			return chosen;
		}
	}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
}