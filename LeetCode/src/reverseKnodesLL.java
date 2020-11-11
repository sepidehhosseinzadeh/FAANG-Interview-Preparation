import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class reverseKnodesLL {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int i = 0;
        while (i < k) {
            if (curr == null) return head;
            curr = curr.next;
            i++;
        }

        ListNode pre = reverseKGroup(curr, k);

        while (i-- > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    // non-recursive
    public ListNode reverseKGroup_v1(ListNode head, int k) {
        int n = 0;
        for (ListNode i = head; i != null; n++, i = i.next) ;

        ListNode dmy = new ListNode(0);
        dmy.next = head;
        for (ListNode prev = dmy, tail = head; n >= k; n -= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }

            prev = tail;
            tail = tail.next;
        }
        return dmy.next;
    }
}
