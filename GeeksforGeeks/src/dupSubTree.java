import java.util.*;
/*Duplicate subtree in Binary Tree:
If the Binary tree contains a duplicate sub-tree of size two or more.
*/

class dupSubTree
{
    static class Node
    {
        char data;
        Node left, right;
        Node(char key)
        {
            data = key;
            left = right = null;
        }
    }
    static HashMap<String, Integer> nsubtree = new HashMap<>();

    public static boolean dupSub(Node root)
    {
        nsubtree.clear();
        preorder(root);

        for(String s : nsubtree.keySet())
            if(s.length() > 3 && nsubtree.get(s) > 1)
                return true;
        return false;
    }

    public static String preorder(Node root)
    {
        String serial = "";
        if(root == null)
        {
            serial += "N";
            return serial;
        }

        serial += root.data;
        serial += preorder(root.left);
        serial += preorder(root.right);

        nsubtree.put(serial, nsubtree.getOrDefault(serial,0)+1);
        return serial;
    }
}