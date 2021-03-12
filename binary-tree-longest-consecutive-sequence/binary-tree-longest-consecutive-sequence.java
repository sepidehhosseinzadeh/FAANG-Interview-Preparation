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
    int max;
    public int longestConsecutive(TreeNode at) {
        max = 0;
        longConsFromNode(at);
        return max;
    }
    public int longConsFromNode(TreeNode at) {
        if(at == null) return 0;
        if(at.left == null && at.right == null) {
            max = Math.max(max,1);
            return 1;
        }
        
        int l = longConsFromNode(at.left);
        int r = longConsFromNode(at.right);
        
        if(at.left != null && at.left.val-1 == at.val) l++;
        else l = 1;
        if(at.right != null && at.right.val-1 == at.val) r++;
        else r = 1;
        
        max = Math.max(max, Math.max(l,r));
        
        return Math.max(l,r);
    }
}