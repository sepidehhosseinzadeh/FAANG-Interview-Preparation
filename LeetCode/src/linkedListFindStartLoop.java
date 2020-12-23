import java.util.*;

public class linkedListFindStartLoop {
	// after finding the meeting point of s and f.
	// assume s after k steps reaches the start of the cycle.
	// if s k steps ahead, then f 2k steps ahead (or k steps ahead of s), or
	// N-k steps behind s (N is len of the cycle). So, if s starts from head,
	// after k steps reaches f (if f moves 1 step at a time from meetin point)
	public ListNode detectCycle(ListNode head) {
		ListNode s = head, f = head;
		while(f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
			if(s == f) break;
		}
		if(s == null || f == null || f.next==null) return null;

		s = head;
		while(s != f) {
			s = s.next;
			if(f == null) return null;
			f = f.next;
		}
		return s;
	}
}
