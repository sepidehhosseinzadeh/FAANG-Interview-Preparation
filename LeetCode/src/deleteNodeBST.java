import java.util.*;

public class deleteNodeBST {
    public static void main(String[] args)
    {
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(key > root.val)
            root.right = deleteNode(root.right, key);

        else //if(key == root.val)
        {
            if(root.right == null) return root.left;
            else if(root.left == null) return root.right;
            else
            {
                // get the biggest on left
                TreeNode at = root.left;
                while(at.right != null) at = at.right;

                int val = at.val;
                root = deleteNode(root, val);
                root.val = val;
                return root;
            }
        }
        return root;
    }
}
