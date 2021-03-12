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
    // O(logn*logn)
    public int countNodes(TreeNode at) {
        if(at == null) return 0;
        
        // logn
        int hl = 0, hr = 0;
        TreeNode l = at, r = at;
        while(l != null) {l=l.left; hl++;}
        while(r != null) {r=r.right; hr++;}
        if(hl == hr) return (1 << hl) -1;
        
        return 1+countNodes(at.left)+countNodes(at.right); // one node will recurse! logn
    }
}