import java.util.*;

public class isBalancedTree {
    class TreeNode
    {
        TreeNode left, right;
        int val;
        TreeNode(int val) {this.val = val;}
    }
    int checkHeight(TreeNode root) {
        if (root == null) return -1;
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up
        //What do we use for an error code? The height of a null tree is generally defined to be -1, so that's not a great idea for an error code. Instead, we' ll use Integer. MIN_VALUE.
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

}
