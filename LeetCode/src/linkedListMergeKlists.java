import java.util.*;

public class linkedListMergeKlists {
	// itertative O(n logk) for each node at most k nodes are in q -> logk min pop
	public ListNode mergeKLists_v0(ListNode[] lists) {
		var q = new PriorityQueue<ListNode>((i,j) -> i.val-j.val);
		for(ListNode node : lists) if(node != null) q.add(node);

		ListNode res = new ListNode(-1);
		ListNode head = res;
		while(!q.isEmpty()) {
			ListNode at = q.poll();

			res.next = new ListNode(at.val);
			res = res.next;

			if(at.next != null) q.add(at.next);
		}

		return head.next;
	}

	// recursive
	public ListNode mergeKLists(ListNode[] lists) {
		return partition(0, lists.length-1, lists);
	}
	ListNode partition(int l, int r, ListNode[] lists) {
		if(l > r) return null;
		if(l == r) return lists[l];
		else {
			int mid = l + (r-l)/2;
			ListNode l1 = partition(l, mid, lists);
			ListNode l2 = partition(mid+1, r, lists);
			ListNode merged = merge2ll(l1,l2);
			return merged;
		}
	}
	ListNode merge2ll(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;

		ListNode head;
		if(l1.val < l2.val) {
			head = l1;
			head.next = merge2ll(l1.next, l2);
		} else {
			head = l2;
			head.next = merge2ll(l1, l2.next);
		}
		return head;
	}
}
