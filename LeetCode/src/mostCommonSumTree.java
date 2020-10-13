import java.util.*;

// most frequent subtree sum
// https://leetcode.com/problems/most-frequent-subtree-sum/

public class mostCommonSumTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    HashMap<Integer, Integer> map;
    int maxCnt;

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        maxCnt = -1;

        sum(root);

        List<Integer> res = new ArrayList<>();
        for (int s : map.keySet())
            if (map.get(s) == maxCnt)
                res.add(s);

        return res.stream().mapToInt(i -> i).toArray();
    }

    int sum(TreeNode t)
    {
        if (t == null) return 0;

        int s = t.val + sum(t.left) + sum(t.right);

        int cnt = map.getOrDefault(s, 0) + 1;
        map.put(s, cnt);

        maxCnt = Math.max(maxCnt, cnt);

        return s;

    }
}
