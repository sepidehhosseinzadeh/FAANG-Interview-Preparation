import java.util.*;

// Add all greater values to every node in a BST
// Modify the BST and return its root
public class addGreaterNodes {
    static class Node
     {
         int data;
         Node left, right;

         public Node(int d)
         {
             data = d;
             left = right = null;
         }
    }

    int prev;
    addGreaterNodes() {prev = 0;}
    public Node modify(Node root)
    {
        if(root == null) return null;

        modify(root.right);

        root.data += prev;
        prev = root.data;

        modify(root.left);

        return root;
    }
}
