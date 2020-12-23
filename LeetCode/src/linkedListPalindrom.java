import java.util.*;

public class linkedListPalindrom {
	public boolean isPalindrome_v0(ListNode head) {
		if(head == null || head.next == null) return true;

		// find middle node: slow
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// reverse till midle
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

	class node {
		ListNode val = null;
		boolean palindrome = true; // is palin till this node
		node(ListNode v, boolean p) {
			val = v; palindrome = p;
		}
	}
	// recursive
	public boolean isPalindrome(ListNode head) {
		// find len
		int len = 0;
		for(ListNode p = head; p != null; p = p.next, len++);

		return isPalin(head, len).palindrome;
	}
	node isPalin(ListNode head, int len) {
		if(head == null || len <= 0) return new node(head, true);
		if(len == 1) return new node(head.next, true);

		node cur = isPalin(head.next, len-2); // stops at middle

		if(!cur.palindrome || cur.val == null) return cur;

		cur.palindrome = cur.val.val == head.val;
		cur.val = cur.val.next;

		return cur;
	}
}
