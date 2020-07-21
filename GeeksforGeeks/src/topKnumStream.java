/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class Node implements Comparable<Node>
    {
        int val, cnt;
        Node(int v, int c)
        {
            val = v; cnt = c;
        }
        public int compareTo(Node o)
        {
            return this.cnt != o.cnt ?
                    o.cnt-this.cnt : this.val-o.val;
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return val == node.val &&
                    cnt == node.cnt;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            final int n = sc.nextInt(), k = sc.nextInt();

            PriorityQueue<Node> q = new PriorityQueue<>();
            HashMap<Integer, Integer> count = new HashMap<>();

            for(int i = 0; i < n; i++)
            {
                int num = sc.nextInt();

                int cnt = count.getOrDefault(num,0);
                if(cnt > 0)
                    q.remove(new Node(num, cnt));
                count.put(num, cnt+1);
                q.add(new Node(num, count.get(num)));

                PriorityQueue<Node> q1 = new PriorityQueue<>();
                int m = Math.min(q.size(),k);
                for(int j = 0; j < m; j++)
                {
                    Node cur = q.remove();
                    System.out.print(cur.val+" ");
                    q1.add(cur);
                }
                while(!q1.isEmpty())
                    q.add(q1.remove());
            }
            System.out.println();
        }
    }
}