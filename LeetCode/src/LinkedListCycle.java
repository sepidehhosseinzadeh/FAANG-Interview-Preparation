import java.util.*;

public class LinkedListCycle {
	// Approch1 : we can use a HashSet to see if we already seen a node before!!!

	// two pointer
	public boolean hasCycle(ListNode head) {
		if(head == null) return false;

		ListNode f = head, s = head;
		while(f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
			if(s == f) return true;
		}
		return false;
	}
}
