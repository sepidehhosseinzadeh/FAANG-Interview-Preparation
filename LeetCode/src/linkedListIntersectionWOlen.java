import java.util.*;

public class linkedListIntersectionWOlen {
	// first iteration when the shorter one reaches the null (end), the longer one is at the
	// len-difference (diff) node point (meaning that after the diff nodes will reach the end.
	// So, in second iteration, when the longer node at diff point moves at the same speed with
	// the shorter one started at the longer head, and when the longer head reaches null,
	// the shorter one moved diff node. The longer one continues from shorter head when reaches the end,
	// they will reach the intersection.
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA, b = headB;
		while(a != b) {
			a = a==null? headB : a.next;
			b = b==null? headA : b.next;
		}
		return a;
	}
}