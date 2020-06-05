import java.util.*;

public class Trie {
    class Solution {
        class Node implements Comparable<Node> {
            int val, cnt;

            Node(int val, int cnt)
            {
                this.val = val;
                this.cnt = cnt;
            }

            @Override
            public int compareTo(Node that)
            {
                return that.cnt - this.cnt;
            }
        }

        class TrieNode {
            TrieNode[] child = new TrieNode[32];
            String val = "";
        }

        void add(String str, TrieNode t)
        {
            for (char c : str.toCharArray()) {
                if (t.child[c - 'a'] == null)
                    t.child[c - 'a'] = new TrieNode();
                t = t.child[c - 'a'];
            }
            t.val = str;
        }

        boolean search(String str, TrieNode t)
        {
            return match(0, str.toCharArray(), t);
        }

        boolean match(int at, char[] ch, TrieNode t)
        {
            if (at == ch.length) return !t.val.equals("");

            if (ch[at] != '.') {
                return t.child[ch[at] - 'a'] != null &&
                        match(at + 1, ch, t.child[ch[at] - 'a']);
            } else {
                for (int i = 0; i < 32; i++)
                    if (t.child[ch[i] - 'a'] != null &&
                            match(at + 1, ch, t.child[ch[i] - 'a']))
                        return true;
                return false;
            }

        }

        public ArrayList<Integer> solve(String goodWords,
                                        ArrayList<String> ratings)
        {

            TrieNode dic = new TrieNode();

            for (String w : goodWords.split("_")) {
                add(w, dic);
            }
            ArrayList<Node> ans = new ArrayList<Node>();
            for (int i = 0; i < ratings.size(); i++) {
                int cnt = 0;
                for (String s : ratings.get(i).split("_"))
                    if (search(s, dic))
                        cnt++;
                ans.add(new Node(i, cnt));
            }
            Collections.sort(ans);

            ArrayList<Integer> res = new ArrayList<Integer>();
            for (Node i : ans)
                res.add(i.val);

            return res;

        }
    }
}
/*
 * // count sort
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] cnt = new int[ratings.size()];
        for(int i = 0; i < ratings.size(); i++)
            for(String s : ratings.get(i).split("_"))
                if(search(s, dic))
                    cnt[i]++;

        for(int i = 1; i < cnt.length; i++)
            cnt[i] += cnt[i-1];

        int[] output = new int[cnt[cnt.length-1]];
        for(int i = cnt.length-1; i >=0; i--)
            if(cnt[i]-1 >= 0)
            {
                res.add(i);
                cnt[i]--;
            }
*/