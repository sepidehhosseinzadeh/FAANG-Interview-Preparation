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
    // becuz when we reach a leaf the max and min is defined and is itself,
    // then max and min should be in return value. In the question
    // "checking if the subtree is bst" the min and max is changing 
    // instanstly by going left/right, so we should pass min/max as input to func.
    
    int MAX = Integer.MAX_VALUE;
    int MIN = Integer.MIN_VALUE;
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        maxSumBst(root);
        return maxSum;
    }
    
    private int[] maxSumBst(TreeNode at) {
        if(at == null) return new int[] {MAX, MIN, 0, 1}; // min, max, sum of subtree, isBST
        
        if(at.left == null && at.right == null) {
            maxSum = Math.max(maxSum, at.val);
            return new int[] {at.val, at.val, at.val, 1};
        }
        
        int[] l = maxSumBst(at.left);
        int[] r = maxSumBst(at.right);
        
        int[] atr = new int[]{at.val,at.val,0,0};
        if(l[3] == 1 && r[3] == 1 && l[1] < at.val && at.val < r[0]) {
            atr[3] = 1; 
            atr[2] = at.val+l[2]+r[2];
            maxSum = Math.max(maxSum, atr[2]);
            atr[0] = Math.min(atr[0], Math.min(l[0],r[0]));
            atr[1] = Math.max(atr[1], Math.max(l[1],r[1]));
        }
        
        return atr.clone();
    }
}