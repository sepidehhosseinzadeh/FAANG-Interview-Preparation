import java.util.*;

public class alianDic {
    class Solution {
        // order is like pre-requisit of courses! topological sort!!!
        // ["wrt","wrf","er","ett","rftt"]
        // ["wrt","wrtkj"] return "jkrtw" -> no order required
        // ["ac","ab","zc","zb"] -> few con comp should be merged
        // ["a","b","a"] -> return "" -> loop
        // ["abc","ab"] -> return "" -> c < "" is wrong!

        public String alienOrder(String[] words) {
            int n = words.length;
            int[] vis = new int[26];
            Arrays.fill(vis, -1); // important!!! not exist = -1, exist and not visited 0!!!
            for(int i = 0; i < n; i++)
                for(char ch : words[i].toCharArray())
                    vis[ch-'a'] = 0;

            ArrayList<Integer>[] neigh = new ArrayList[26];
            // boolean[][] adj is better!
            for(int i = 0; i < 26; neigh[i]=new ArrayList<Integer>(),i++);


            for(int i = 0; i+1 < n; i++) {
                char[] w1 = words[i].toCharArray();
                char[] w2 = words[i+1].toCharArray();

                // second string cannot be bigger ["abc","ab"] -> ""
                if(words[i].startsWith(words[i+1]) && !words[i+1].equals(words[i]))  return "";

                int j = 0, m = Math.min(w1.length, w2.length);
                while(j < m && w1[j] == w2[j]) j++;
                if(j < m) neigh[w1[j]-'a'].add(w2[j]-'a');
            }

            StringBuilder order = new StringBuilder("");
            for(int i = 0; i < 26; i++)
                if(vis[i] == 0)
                    if(!dfs(i, neigh, vis, order)) return "";

            return order.toString();

        }

        boolean dfs(int at, ArrayList<Integer>[] neigh, int[] vis, StringBuilder order) {
            vis[at] = 1;

            for(int to : neigh[at]) {
                if(vis[to] == 2) continue;
                if(vis[to] == 1) return false; // loop
                vis[to] = 1;
                if(!dfs(to, neigh, vis, order)) return false;
            }

            vis[at] = 2;
            order.insert(0,(char)(at+'a'));
            return true;
        }
    }
}
