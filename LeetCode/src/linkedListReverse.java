import java.util.*;

public class LinkedListReverse {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */

	// recursive :
	/* Assume that the rest of the list had already been reversed, now how do I reverse the front part?
	 Let's assume the list is:
	n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
	 Assume from node nk+1 to nm had been reversed and you are at node nk.
	n1 → … → nk-1 → nk → nk+1 ← … ← nm
	 We want nk+1’s next node to point to nk. So,
	nk.next.next = nk;

	*n1's next must point to Ø. linklist has a cycle in it -> test linklist of size 2.
	*/
	public ListNode reverseList(ListNode cur) {
		if (cur == null || cur.next == null) //if there's non/1 node reversed is itself
			return cur;

		ListNode reversed = reverseList(cur.next); // reversed is from cur.next

		// add me: cur.next .next points to me instead of
		cur.next.next = cur;
		// remove loop
		cur.next = null;

		// return reveresd including me
		return reversed;
	}

	public ListNode reverseList_v1(ListNode cur) {
		return reverse(null, cur);
	}
	ListNode reverse(ListNode prev, ListNode cur) {
		if (cur == null) return prev;

		ListNode next = cur.next;
		cur.next = prev; // reverse cur and prev link
		return reverse(cur, next);
	}


	// itertative
	public ListNode reverseList_v0(ListNode head) {
		if (head == null) return null;
		ListNode newHead = new ListNode(head.val);

		while (head.next != null) {
			ListNode next = new ListNode(head.next.val);
			next.next = newHead;
			newHead = next;

			head = head.next;
		}
		return newHead;

	}
}