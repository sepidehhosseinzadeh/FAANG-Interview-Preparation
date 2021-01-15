/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxl;
    public int diameter(TreeNode root) {
        if(root == null) return 0;
        
        int dl = diameter(root.left)+1;
        int dr = diameter(root.right)+1;
        
        maxl = Math.max(maxl, dl+dr-2);
        
        return Math.max(dl, dr);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxl = 0;
        diameter(root);
        return maxl;
    }
}
