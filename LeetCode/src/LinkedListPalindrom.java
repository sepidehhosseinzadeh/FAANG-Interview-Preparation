import java.util.*;

public class LinkedListPalindrom {
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) return true;

		// find middle node: slow
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		boolean reversed = false;
		ListNode t = head, prev = null;
		while(t != slow) {
			ListNode next = t.next;
			t.next = prev;
			prev = t;
			t = next;
		}
		if(fast != null) t = t.next;
		while(t != null) {
			if(t.val != prev.val) return false;
			t = t.next;
			prev = prev.next;
		}
		return true;
	}
}
