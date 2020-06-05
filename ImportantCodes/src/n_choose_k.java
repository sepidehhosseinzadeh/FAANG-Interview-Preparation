import java.util.*;

public class n_choose_k {
    class Solution {
        ArrayList<ArrayList<Integer>> res;

        public ArrayList<ArrayList<Integer>> combine(int n, int k)
        {
            res = new ArrayList<ArrayList<Integer>>();
            dfs(1, n, k, new ArrayList<Integer>());
            return res;
        }

        public void dfs(int at, int n, int k, ArrayList<Integer> cur)
        {
            if (at == k + 1) {
                res.add(new ArrayList<Integer>(cur));
                return;
            }
            for (int i = 1; i <= n; i++) {
                cur.add(i);
                dfs(at + 1, n, k, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
