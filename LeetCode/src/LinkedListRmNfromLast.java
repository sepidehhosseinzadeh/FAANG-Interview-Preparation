import java.util.*;

public class LinkedListRmNfromLast {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || head.next == null) return null;

		ListNode h = new ListNode(0);
		h.next = head;
		ListNode l = h, r = h;
		for(int i = 0; i <= n; i++) {
			r = r.next;
			if(r == null && i < n-1) return null;
		}

		while(r != null) {
			l = l.next;
			r = r.next;
		}
		l.next = l.next.next;
		return h.next;
	}
}
