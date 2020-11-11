import java.util.*;
import java.lang.*;

// Top k numbers in a stream: print all distinct elements sorted by frequency.
class topKnumStream {

    static ArrayList<Integer> kTop(int[] a, int n, int k)
    {
        var res = new ArrayList<Integer>();
        var count = new HashMap<Integer, Integer>();
        var q = new PriorityQueue<Integer>((i,j) ->
                count.get(i)!=count.get(j)?count.get(j)-count.get(i):i-j);

        for(int i = 0; i < n; i++)
        {
            int num = a[i];

            int cnt = count.getOrDefault(num,0);
            if(cnt > 0) q.remove(num);
            count.put(num, cnt+1);
            q.add(num);

            int size = Math.min(q.size(),k);
            var tmp = new ArrayList<Integer>();
            for(int j = 0; j < size; j++)
            {
                int cur = q.remove();
                res.add(cur);
                tmp.add(cur);
            }
            for(int e : tmp) q.add(e);
        }

        return res;
    }

    // prev approach
    static class Node implements Comparable<Node>
    {
        int val, cnt;
        Node(int v, int c) {val = v; cnt = c;}
        @Override
        public int compareTo(Node o) {
            return this.cnt != o.cnt ?
                    o.cnt - this.cnt : this.val - o.val;
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