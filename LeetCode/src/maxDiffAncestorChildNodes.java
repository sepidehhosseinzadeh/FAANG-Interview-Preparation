import java.util.*;

public class maxDiffAncestorChildNodes {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root, -1, 100001);
    }

    int maxDiff(TreeNode t, int curMax, int curMin)
    {
        if (t == null) return curMax - curMin;

        return Math.max(maxDiff(t.left, Math.max(t.val, curMax),
                Math.min(t.val, curMin)),
                maxDiff(t.right, Math.max(t.val, curMax),
                        Math.min(t.val, curMin)));
    }
}