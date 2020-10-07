import java.util.*;
/*
https://www.geeksforgeeks.org/flattening-a-linked-list/
 */
public class flattenLinkedListOfLinkedList {
    static class LinkedList {
        Node head;

        static class Node {
            int data;
            Node next;
            Node bottom;

            Node(int d)
            {
                data = d;
                next = null;
                bottom = null;
            }
        }

        void printList()
        {
            Node temp = head;
            while (temp != null)
            {
                System.out.print(temp.data + " ");
                temp = temp.bottom;
            }
            System.out.println();
        }

        Node push(Node head_ref, int data)
        {
            Node new_node = new Node(data);
            new_node.bottom = head_ref;
            head_ref = new_node;
            return head_ref;
        }

        public static void main(String[] args)
        {
            LinkedList L = new LinkedList();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */
            L.head = L.push(L.head, 30);
            L.head = L.push(L.head, 8);
            L.head = L.push(L.head, 7);
            L.head = L.push(L.head, 5);

            L.head.next = L.push(L.head.next, 20);
            L.head.next = L.push(L.head.next, 10);

            L.head.next.next = L.push(L.head.next.next, 50);
            L.head.next.next = L.push(L.head.next.next, 22);
            L.head.next.next = L.push(L.head.next.next, 19);

            L.head.next.next.next = L.push(L.head.next.next.next, 45);
            L.head.next.next.next = L.push(L.head.next.next.next, 40);
            L.head.next.next.next = L.push(L.head.next.next.next, 35);
            L.head.next.next.next = L.push(L.head.next.next.next, 20);

            // flatten the list
            L.head = L.flatten(L.head);
            L.printList();

        }

        static Node flatten(Node root)
        {
            if (root == null || root.next == null) return root;

            Node head = root;
            Node p = root.next;

            while (p != null) {
                Node curr = null;
                Node t = null;
                Node t1 = head, t2 = p;
                while (t1 != null || t2 != null) {
                    if (t2 == null && t1 != null ||
                            t1 != null && t2 != null && t1.data <= t2.data) {
                        if(curr == null) {
                            curr = new Node(t1.data);
                            t = curr;
                        }
                        else {
                            t.bottom = new Node(t1.data);
                            t = t.bottom;
                        }
                        t1 = t1.bottom;
                    }
                    else if (t1 == null && t2 != null ||
                            t1 != null && t2 != null && t1.data >= t2.data) {
                        if(curr == null) {
                            curr = new Node(t2.data);
                            t = curr;
                        }
                        else {
                            t.bottom = new Node(t2.data);
                            t = t.bottom;
                        }
                        t2 = t2.bottom;
                    }
                }
                p = p.next;
                head = curr;
            }

            return head;

        }

        static class pair {
            int val;
            Node head;

            pair(Node head, int val)
            {
                this.val = val;
                this.head = head;
            }
            public int compareTo(pair o)
            {
                return this.val - o.val;
            }
        }
        static class pairComp implements Comparator<pair> {
            public int compare(pair p1, pair p2)
            {
                return p1.val - p2.val;
            }
        }
        public static Node flatten_pq(Node root)
        {
            Node ptr = root;
            Node h = null;

            PriorityQueue<pair> pq = new PriorityQueue<pair>();

            while (ptr != null) {
                pq.add(new pair(ptr, ptr.data));
                ptr = ptr.next;
            }

            while (!pq.isEmpty()) {

                Node temp = pq.poll().head;

                if (temp.bottom != null) {
                    pq.add(new pair(temp.bottom,
                            temp.bottom.data));
                }

                if (h == null) {
                    h = temp;
                    ptr = temp;
                } else {
                    ptr.bottom = temp;
                    ptr = temp;
                }
            }
            return h;
        }
    }
}
