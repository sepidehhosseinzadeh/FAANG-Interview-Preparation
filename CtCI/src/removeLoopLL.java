import java.util.*;

public class removeLoopLL {
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    }
    static class LinkedList
    {
        Node head;
        Node next;
    }
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;

        Node t = list.head;
        for(int i = 0; i < 10; i++) {
            System.out.print(t.data+" ");
            if(t.next == null)
                break;
            t = t.next;
        }

        removeLoop(list);
        System.out.println("\n Linked List after removing loop : ");

        t = list.head;
        for(int i = 0; i < 10; i++) {
            System.out.print(t.data+" ");
            if(t.next == null)
                break;
            t = t.next;
        }
    }
    static void removeLoop(LinkedList l){
        // If the size of the tail of the loop is k,
        // If slowPointer took k steps and is at start
        // of the loop, fastPointer took 2k steps, or
        // k steps into the loop, or n=LOOP_SIZE-k steps
        // behind slowPointer. So, fastPointer will meet slow
        // after n steps, becuz if slow takes n steps, then it'll
        // be at 2n, and fast will be 2n too. So, they will meet
        // after 1 step/time. So, we will get the collision spot,
        // then a pointer from head, a pointer at collision node,
        // and move them at a same pace (will be k steps), it will
        // be at head of the loop.
        // keep the prev point.


        Node s = l.head, f = l.head;
        while(f != null && f.next != null)
        {
            s = s.next;
            f = f.next.next;
            if(s == f) break;
        }

        // no meeting point - no loop
        if(f == null || f.next == null) return;

        s = l.head;
        while(s != f)
        {
            if(f.next == s.next) {
                f.next = null; return;
            }
            f = f.next;
            s = s.next;
        }
    }
}
