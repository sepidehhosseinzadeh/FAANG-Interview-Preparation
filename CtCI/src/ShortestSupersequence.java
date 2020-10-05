import java.util.*;

// This is the Greedy approach with a assumtion that the small array doeasn't have repeation.
// SCS: Shortest Common Supersequence

public class ShortestSupersequence {
    /*Given two arrays, one shorter (with all distinct elements) and one longer.
    Find the shortest subarray in the longer array
    that contains all elements in shorter array.*/

    static class Node implements Comparable<Node>
    {
        int key, loc;
        Node(int k, int i)
        {
            key = k;
            loc = i;
        }
        Node(){}
        public int compareTo(Node that)
        {
            return this.loc-that.loc;
        }
    }
    public static void main(String[] args)
    {
        /*
        {1, 5, 9}
        {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}
        Output:[7, 10] (the underlined portion above)
         */
        int[] small = new int[] {1, 5, 9};
        int[] big = new int[] {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] res = findShortestSubarray(big, small);
        System.out.println("start: "+ res[0]+", end: "+ res[1]+", len: "+ res[2]);
    }
    private static int[] findShortestSubarray(int[] big, int[] small)
    {
        HashMap<Integer, Queue<Integer>> table = new HashMap<>();
        for(int s : small)
            table.put(s, new LinkedList<>());

        for(int i = 0; i < big.length; i++)
        {
            if(table.containsKey(big[i]))
                table.get(big[i]).add(i);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        int minIdx = Integer.MAX_VALUE, maxIdx = Integer.MIN_VALUE;
        for(int key : table.keySet())
        {
            int idx = table.get(key).peek();
            queue.add(new Node(key, idx));

            minIdx = Math.min(minIdx, idx);
            maxIdx = Math.max(maxIdx, idx);
        }

        int curMaxIdx = maxIdx;
        while (queue.size() >= small.length)
        {
            Node at = queue.poll();

            int curMinKey = at.key;
            int curMinIdx = at.loc;
            table.get(curMinKey).poll();

            if(curMaxIdx-curMinIdx < maxIdx-minIdx)
            {
                minIdx = curMinIdx;
                maxIdx = curMaxIdx;
            }

            if(table.get(curMinKey).size() == 0)
                break;

            int newMinIdx = table.get(curMinKey).peek();
            queue.add(new Node(curMinKey, newMinIdx));

            curMaxIdx = Math.max(curMaxIdx, newMinIdx);
        }

        return new int[]{minIdx, maxIdx, maxIdx-minIdx+1};
    }
}
