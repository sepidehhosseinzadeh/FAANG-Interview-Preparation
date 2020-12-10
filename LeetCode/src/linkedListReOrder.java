import java.util.*;

public class linkedListReOrder {
	// iterative
	public void reorderList_v0(ListNode head) {
		if(head == null || head.next == null) return;

		var stack = new Stack<ListNode>();

		ListNode s = head, f = head;
		while(f != null && f.next != null) {
			stack.push(s);
			s = s.next;
			f = f.next.next;
		}
		if(f != null) { // odd number of nodes
			mid = s;
			s = s.next;
		}

		ListNode post = null;
		boolean add = false;
		while(!stack.isEmpty()) {
			ListNode at = stack.pop();
			at.next = s;

			ListNode next = s.next;
			if(f != null && !add) {
				s.next = mid;
				if(mid != null) mid.next = null;
				add = true;
			} else {
				s.next = post;
			}

			post = at;
			s = next;
		}
	}

	// recursive

	public void reorderList(ListNode head) {
		if(head == null || head.next == null) return;

		reorder(head, head);
	}
	ListNode reorder(ListNode head, ListNode last) {
		if(last == null) return head;

		ListNode nextHead = reorder(head, last.next);
		if(nextHead == null) return null;

		if(nextHead == last || nextHead.next == last) {last.next = null;return null;}
		ListNode next = nextHead.next;
		nextHead.next = last;
		last.next = next;

		return next;
	}

	ListNode mid;
	boolean add;
	public void reorderList_v1(ListNode head) {
		if(head == null || head.next == null) return;

		add = false;
		mid = null;
		int len = 0;
		for(ListNode cur = head; cur != null; cur=cur.next, ++len);

		reorder(head, head.next, len);
	}
	ListNode reorder(ListNode at, ListNode post, int len) {
		// len >= 2
		if(len == 0) return at;
		else if(len == 1) {
			mid = at;
			return at.next;
		}

		ListNode then = reorder(at.next, post.next, len-2);

		ListNode next = then.next;

		if(!add) {then.next = mid; if(mid!=null)mid.next = null; add = true;}
		else then.next = post;

		at.next = then;
		then = next;

		return then;
	}
}
