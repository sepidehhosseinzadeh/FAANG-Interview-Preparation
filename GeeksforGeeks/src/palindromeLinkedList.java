import java.util.*;

// check if the linkedList is palindrome. 
// slow and fast pointer approach. While slow is moving, we reverse the pointer, 
// until fast points to last element. Then, move together and check.

class palindromeLinkedList
{
    static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int key)
        {
            val = key;
            next = null;
        }
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    static boolean isPalindrome(ListNode head)
    {
       if (head == null || head.next == null) return true;
       // reverse the first portion during iteration
       ListNode fast = head, newHead = null;
       while (fast != null && fast.next != null) {
           fast = fast.next.next;
           ListNode next = head.next;
           head.next = newHead;
           newHead = head;
           head = next;
       }
       // skip the node at central place if the list contains odd number of nodes
       if (fast != null) head = head.next;
       while (newHead != null && head != null) {
           if (newHead.val != head.val) return false;
           newHead = newHead.next;
           head = head.next;
       }
       return true;
   }
}
