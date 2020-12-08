import java.util.*;

public class LinkedListPalindromNM {
	// recursive (two pass)
	public ListNode reverseBetween_v0(ListNode head, int m, int n) {
		if(head == null) return null;
		if(m == 1) {
			return reverseN(head, n);
		}
		head.next = reverseBetween(head.next, m-1, n-1);
		return head;

	}
	ListNode successor = null;
	ListNode reverseN(ListNode head, int n) {
		if(n == 1) {
			successor = head.next;
			return head;
		}
		ListNode reversed = reverseN(head.next, n-1);
		head.next.next = head;
		head.next = successor;
		return reversed;
	}


	// itertative (one pass)
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || head.next == null) return head;

		ListNode t = head, prev = null, next = null, mNode = null, prevMnode = null;
		for(int i = 1; i <= n; i++) {
			next = t.next;
			if(i == m-1) prevMnode = t;
			if(i == m) mNode = t;
			if(i > m) t.next = prev;

			prev = t;
			t = next;
		}
		if(prevMnode != null) prevMnode.next = prev; // prev has nth node
		else head = prev;
		mNode.next = next; // next has n+1 th node

		return head;
	}
}
