/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countUnivalSubtrees_v0(TreeNode root) {
        if(root == null) return 0;
        return countUniSub(root)+
            countUnivalSubtrees(root.left)+
            countUnivalSubtrees(root.right);
    }
    private int countUniSub(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int nl = countUniSub(root.left);
        int nr = countUniSub(root.right);
        
        if(nl == 0 && root.left!=null || nr == 0 && root.right!=null)
            return 0;
        if((root.left!=null && root.val == root.left.val) &&
            (root.right!=null && root.val == root.right.val))
            return 1;
        else if(root.left==null && root.val == root.right.val)
            return 1;
        else if(root.right==null && root.val == root.left.val)
            return 1;
        return 0;     
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        countUniSub(root, count);
        return count[0];
    }
    private boolean countUniSub(TreeNode root, int[] count) {
        if(root == null) return true;
        
        boolean l = countUniSub(root.left, count);
        boolean r = countUniSub(root.right, count);
        
        if(!l || !r) return false;
        if((root.left==null || root.val == root.left.val) && 
          (root.right==null || root.val == root.right.val)) {count[0]++; return true;}
        return false;
    }
}











