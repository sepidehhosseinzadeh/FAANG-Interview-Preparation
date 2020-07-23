import java.util.*;

public class leaves2DLL {
    // Given a Binary Tree, the task is to extract all leaves of it
    // in a Doubly Linked List (DLL).
    // return the head of the DLL and remove those node from the tree as well.

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    Node dll, head;
    public Node convertToDLL(Node root)
    {
        dll = head = null;
        root = conv(root);
        return head;
    }
    Node conv(Node root)
    {
        if(root == null)  return null;

        if(root.left == null && root.right == null)
        {
            if(head == null)
            {
                dll = root;
                head = root;
            }
            else
            {
                dll.right = root;
                dll.right.left = dll;
                dll = dll.right;
            }
            return null;
        }

        root.left = convertToDLL(root.left);
        root.right = convertToDLL(root.right);

        return root;
    }
}
