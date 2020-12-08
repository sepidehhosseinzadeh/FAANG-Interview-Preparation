import java.util.*;

public class linkedListMerge2Sorted {
	// iterative
	public ListNode mergeTwoLists_v0(ListNode l1, ListNode l2) {
		ListNode p1 = l1, p2 = l2;
		ListNode res = new ListNode(0);
		ListNode head = res;
		while(p1 != null && p2 != null) {
			if(p1.val < p2.val) {
				res.next = new ListNode(p1.val);
				p1 = p1.next;
			} else {
				res.next = new ListNode(p2.val);
				p2 = p2.next;
			}
			res = res.next;
		}

		// exactly one of them will bw null!
		res.next = p1 == null ? p2 : p1;
		return head.next;
	}

	// recursive
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;

		ListNode mergeHead;
		if(l1.val < l2.val) {
			mergeHead = l1;
			mergeHead.next = mergeTwoLists(l1.next, l2);
		} else {
			mergeHead = l2;
			mergeHead.next = mergeTwoLists(l1, l2.next);
		}
		return mergeHead;
	}
	public ListNode mergeTwoLists_v1(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) return null;
		if(l1 == null) return l2;
		if(l2 == null) return l1;

		if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
