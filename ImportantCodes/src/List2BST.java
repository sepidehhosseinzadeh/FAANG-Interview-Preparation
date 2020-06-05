public class List2BST {
      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
      class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
      }

    public class Solution {
        public TreeNode sortedListToBST(ListNode a) {
            ListNode slow = a, fast = a, prev = null;

            while(fast != null && fast.next != null)
            {
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }

            TreeNode root = new TreeNode(slow.val);

            if(prev != null)
                prev.next = null;
            else
                a = null;


            root.left = sortedListToBST(a);
            root.right = sortedListToBST(slow.next);

            return root;
        }
    }

}
