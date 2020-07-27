import java.util.*;

public class findDeepNodesParent {
    private class TreeNode {
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

    private class Solution {
        ArrayList<TreeNode> deepParent;
        int maxDepth;

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if (root == null) return null;
            if (root.left == null && root.right == null) return root;

            deepParent = new ArrayList<>();
            maxDepth = -1;

            getMaxDepth(root, null, 0);
            addMaxDepth(root, 0);
            return findDeepParent(root);

        }

        boolean cover(TreeNode root, TreeNode node)
        {
            if (root == null) return false;
            if (root.val == node.val) return true;

            if (cover(root.left, node)) return true;
            if (cover(root.right, node)) return true;

            return false;
        }

        boolean coverAll(TreeNode at)
        {
            for (TreeNode node : deepParent)
                if (!cover(at, node))
                    return false;
            return true;
        }

        TreeNode findDeepParent(TreeNode at)
        {
            if (at == null) return null;

            boolean left = coverAll(at.left);
            boolean right = coverAll(at.right);
            if (left) return findDeepParent(at.left);
            if (right) return findDeepParent(at.right);

            return at;
        }

        void addMaxDepth(TreeNode at, int depth)
        {
            if (at == null) return;

            if (depth == maxDepth)
                deepParent.add(at);

            addMaxDepth(at.left, depth + 1);
            addMaxDepth(at.right, depth + 1);

        }

        int getMaxDepth(TreeNode at, TreeNode parent, int depth)
        {
            if (at == null) return depth - 1;
            if (at.left == null && at.right == null) return depth;

            int ldepth = getMaxDepth(at.left, at, depth + 1);
            int rdepth = getMaxDepth(at.right, at, depth + 1);
            maxDepth = Math.max(maxDepth, Math.max(ldepth, rdepth));

            return depth;
        }
    }

    private class Solution_opt {
        TreeNode deepParent;
        int maxDepth;

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            deepParent = null;
            maxDepth = -1;

            getMaxDepth(root, 0);
            return deepParent;

        }

        int getMaxDepth(TreeNode at, int depth)
        {
            if (at == null) return depth;

            int ldepth = getMaxDepth(at.left, depth + 1);
            int rdepth = getMaxDepth(at.right, depth + 1);
            int atdepth = Math.max(ldepth, rdepth);
            maxDepth = Math.max(maxDepth, atdepth);

            if (ldepth == maxDepth && rdepth == maxDepth)
                deepParent = at;

            return atdepth;
        }
    }


    private class Solution_opt1 {
        private class Pair<T, K> {
            final T key;
            final K value;

            public Pair(T key, K value) {
                this.key = key;
                this.value = value;
            }

            public K getValue() {
                return value;
            }

            public T getKey() {
                return key;
            }
        }

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return height(root).getValue();
        }

        private Pair<Integer, TreeNode> height(TreeNode root) {
            if (root == null) return new Pair(0, null);

            Pair<Integer, TreeNode> left = height(root.left);
            Pair<Integer, TreeNode> right = height(root.right);

            int leftHeight = left.getKey();
            int rightHeight = right.getKey();
            if (leftHeight == rightHeight) {
                return new Pair(leftHeight + 1, root);
            }
            else if (leftHeight < rightHeight) {
                return new Pair(rightHeight + 1, right.getValue());
            }
            else {
                return new Pair(leftHeight + 1, left.getValue());
            }
        }
    }
}
