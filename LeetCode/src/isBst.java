import java.util.*;

public class isBst {
    public boolean isValidBST(TreeNode root) {
        return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    boolean isBst(TreeNode root, long min, long max)
    {
        if(root == null) return true;

        boolean left = isBst(root.left, min, root.val);
        if(!left) return false;
        boolean right = isBst(root.right, root.val, max);
        if(!right) return false;

        boolean is = root.val > min && root.val < max;
        return is;
    }
}
