/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
/*
Given a string S with repeated characters (only lowercase).
Rearrange characters in a string such that
no two adjacent characters are same.
 */
class Node implements Comparable<Node>
{
    char ch;
    int cnt;
    Node(char ch, int cnt)
    {
        this.ch = ch;
        this.cnt = cnt;
    }
    public int compareTo(Node that)
    {
        return that.cnt-this.cnt;
    }
}

class GFG {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        while(t-- > 0)
        {
            String s = scan.nextLine();
            System.out.println(canAlter(s)?1:0);
        }

    }
    static boolean canAlter(String s)
    {
        int[] cnt = new int[26];
        for(char c : s.toCharArray())
            cnt[c-'a']++;

        PriorityQueue<Node> q = new PriorityQueue<>();
        for(char i = 'a'; i <= 'z'; i++)
            if(cnt[i-'a'] > 0)
                q.add(new Node(i, cnt[i-'a']));

        String res = "";
        Node prev = null;
        while(!q.isEmpty())
        {
            Node at = q.poll();
            if(at.cnt == 0)
                continue;
            res += at.ch;
            at.cnt--;

            if(prev != null)
                if(prev.cnt > 0)
                    q.add(prev);

            prev = at;
        }
        System.out.println(res);
        return res.length() == s.length();

    }
}