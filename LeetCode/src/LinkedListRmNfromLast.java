import java.util.*;

public class LinkedListRmNfromLast {
	public ListNode removeNthFromEnd_v0(ListNode head, int n) {
		if (head == null || head.next == null) return null;

		ListNode h = new ListNode(0);
		h.next = head;
		ListNode l = h, r = h;
		for (int i = 0; i <= n; i++) { // gap == n
			r = r.next;
			if (r == null && i < n - 1) return null;
		}

		while (r != null) {
			l = l.next;
			r = r.next;
		}

		l.next = l.next.next; // we need to change next link!!!
		// if work with itself, node=node.next -> will be replaced!!!!!!!
		return h.next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null) return null;

		ListNode l = head, r = head;
		for (int i = 0; i < n; i++) { // gap == n-1
			r = r.next;
			if (r == null && i < n - 1) return null;
		}
		if (r == null) return head.next; // head needs to be removed!!

		r = r.next; // gap == n now

		while (r != null) {
			l = l.next;
			r = r.next;
		}

		l.next = l.next.next;
		return head;
	}
}
