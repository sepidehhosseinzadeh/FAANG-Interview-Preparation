import java.util.*;


public class cntSubTreeInRange {
// count subtrees that lie in a given range
    static class node {
        int data;
        node left, right;
    }
    static int count = 0;
    static boolean getCountUtil(node root, int low, int high)
    {
        if (root == null)
            return true;

        boolean l = getCountUtil(root.left, low, high);
        boolean r = getCountUtil(root.right, low, high);

        if (l && r &&   root.data >= low && root.data <= high) {
            ++count;
            return true;
        }

        return false;
    }
}
