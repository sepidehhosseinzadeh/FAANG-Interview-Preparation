import java.util.*;
public class LevelOrder {
     class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
             val = x;
             left=null;
             right=null;
         }
     }

    public class Solution {

        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A)
        {
            Queue<TreeNode> q = new LinkedList<TreeNode>();

            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            q.add(A);

            while(!q.isEmpty())
            {
                int n = q.size();
                ArrayList<Integer> al = new ArrayList<Integer>();
                for(int i = 0; i < n; i++)
                {
                    TreeNode at = q.remove();
                    al.add(at.val);

                    TreeNode l, r;
                    if(at.left != null)
                    {
                        q.add(at.left);
                    }
                    if(at.right != null)
                    {
                        q.add(at.right);
                    }
                }
                res.add(al);
            }

            return res;

        }
    }
}
