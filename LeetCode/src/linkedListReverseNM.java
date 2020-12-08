import java.util.*;

public class LinkedListReverseNM {
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
		else head = prev; // if n == 1 there's no prevMnode, so head is pointed to nth node (prev has nth node)
		mNode.next = next; // next has n+1 th node

		return head;
	}

	// awsome!!!!
	public ListNode reverseBetween_v1(ListNode head, int m, int n) {
		if(head == null) return null;
		ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
		dummy.next = head;
		ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
		for(int i = 0; i<m-1; i++) pre = pre.next;

		ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
		ListNode then = start.next; // a pointer to a node that will be reversed

		// 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
		// dummy-> 1 -> 2 -> 3 -> 4 -> 5

		for(int i=0; i<n-m; i++)
		{
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}

		// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
		// second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

		return dummy.next;

	}
}
