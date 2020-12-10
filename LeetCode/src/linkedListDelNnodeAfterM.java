import java.util.*;

public class linkedListDelNnodeAfterM {
	// itertative
	public ListNode deleteNodes_v0(ListNode head, int m, int n) {
		ListNode h = new ListNode(-1), newHead = h;
		h.next = head;
		while (h != null) {
			for (int i = 0; i < m && h != null; i++) h = h.next;
			if (h == null) break;

			for (int i = 0; i < n; i++)
				if (h.next != null)
					h.next = h.next.next;
		}
		return newHead.next;
	}

	// itertative, without dummy node
	public ListNode deleteNodes(ListNode head, int m, int n) {
		ListNode pre = null, cur = head;

		while (cur != null) {
			for (int i = 0; i < m && cur != null; i++) {
				pre = cur;
				cur = cur.next;
			}
			for (int i = 0; i < n && pre.next != null; i++)
				pre.next = pre.next.next;
			cur = pre.next;
		}
		return head;
	}


	// recursive
	public ListNode deleteNodes_v1(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		return deleteNodes(dummy, m, n, m).next;
	}

	public ListNode deleteNodes(ListNode head, int m, int n, int M) {
		if (head == null) return null;

		if (m == 0) {
			for (int i = 0; i < n && head.next != null; i++)
				head.next = head.next.next;
			m = M;
		}

		if (m > 0 && head != null)
			head.next = deleteNodes(head.next, m - 1, n, M);

		return head;
	}
}
