import java.util.*;

// 1- Insert first BST into other one.
// 2- have inorder traversal of both in arrays (will be sorted), then merge two sorted arrays.
// 3-  inorder traversal of both with a help of stacks
public class merge2BSTs {
    public static void main(String[] args)
    {
        Node root1 = null, root2 = null;

        /* Let us create the following tree as first tree
             3
            / \
            1 5
        */
        root1 = new Node(3) ;
        root1.left = new Node(1);
        root1.right = new Node(5);

        /* Let us create the following tree as second tree
             4
            / \
            2 6
        */
        root2 = new Node(4) ;
        root2.left = new Node(2);
        root2.right = new Node(6);

        // Print sorted nodes of both trees
        List<Integer> res = merge(root1, root2);

        for(int i: res) System.out.print(i+" ");
    }

    // Return a integer of integers having all the nodes in both the BSTs in a sorted order.
    static List<Integer> merge(Node root1, Node root2)
    {
        List<Integer> res = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node t1 = root1;
        Node t2 = root2;

        while (t1 != null || t2 != null || !s1.isEmpty() || !s2.isEmpty()) {
            while (t1 != null || t2 != null) {
                if (t1 != null) {
                    s1.add(t1);
                    t1 = t1.left;
                }
                if (t2 != null) {
                    s2.add(t2);
                    t2 = t2.left;
                }
            }

            if (s1.isEmpty() || s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    t1 = s1.pop();
                    t1.left = null;
                    inorder(t1, res);
                }
                while (!s2.isEmpty()) {
                    t2 = s2.pop();
                    t2.left = null;
                    inorder(t2, res);
                }
                return res;
            }

            t1 = s1.pop();
            t2 = s2.pop();
            if (t1.data < t2.data) {
                res.add(t1.data);
                t1 = t1.right;

                s2.add(t2);
                t2 = null;
            }
            else {
                res.add(t2.data);
                t2 = t2.right;

                s1.add(t1);
                t1 = null;
            }
        }

        return res;
    }
    static void inorder(Node at, List<Integer> res)
    {
        if(at == null) return;
        inorder(at.left, res);
        res.add(at.data);
        inorder(at.right, res);
    }

}
