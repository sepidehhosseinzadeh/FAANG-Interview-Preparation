import java.util.*;

public class alternateChar {
    public static void main(String[] args)
    {
        System.out.println(reorganizeString("aab"));
    }
    private static class Node implements Comparable<Node>
    {
        char val;
        int cnt;
        Node(char v, int c)
        {
            val = v;
            cnt = c;
        }
        @Override
        public int compareTo(Node o)
        {
            return o.cnt - cnt;
        }
    }
    public static String reorganizeString(String S) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] cnt = new int[26];
        for(char c : S.toCharArray())
            cnt[c-'a']++;
        for(int i = 0; i < 26; i++)
            if(cnt[i] > 0)
                q.add(new Node((char)(i+'a'), cnt[i]));

        Node prev = null;
        String res = "";
        while(!q.isEmpty())
        {
            Node at = q.remove();
            at.cnt--;
            res += at.val;
            if(prev != null && prev.cnt != 0) q.add(prev);
            prev = at;
        }
        return res.length() == S.length() ? res : "";
    }
}
