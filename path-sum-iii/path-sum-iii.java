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
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> cnt = new HashMap();
        cnt.put(0, 1);
        return pathSumRec(root, sum, 0, cnt);
    }
    
    int pathSumRec(TreeNode at, int sum, 
                  int curSum, HashMap<Integer, Integer> cnt) {
        if(at == null) return 0;
        
        curSum += at.val;
        
        int curCnt = cnt.getOrDefault(curSum-sum, 0);
        
        cnt.put(curSum, cnt.getOrDefault(curSum,0)+1);
        
        curCnt += pathSumRec(at.left, sum, curSum, cnt);
        curCnt += pathSumRec(at.right, sum, curSum, cnt);
        
        cnt.put(curSum, cnt.getOrDefault(curSum,0)-1);        
        
        return curCnt;
    }
}