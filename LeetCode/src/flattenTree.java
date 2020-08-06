import java.util.*;

public class flattenTree {
    /* If we traverse the flattened tree in the reverse way,
    we would notice that [6->5->4->3->2->1] is in (right, left, root) order of the original tree.
    So the reverse order after flattening is post order traversal in (right, left, root)
    order like [6->5->4->3->2->1].
    Given a binary tree, flatten it to a linked list in-place.

    For example, given the following tree:

        1
       / \
      2   5
     / \   \
    3   4   6
    The flattened tree should look like:

    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6
*/
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // static TreeNode prev = null; NOTE: STATIC WRONG: for all objects there is only one instance!
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
