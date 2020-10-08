import java.util.*;

// print vertical order of a binary tree
public class verticalOrderTree {
    static class Node
    {
        int key;
        Node left;
        Node right;

        // Constructor
        Node(int data)
        {
            key = data;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args)
    {
    }
    static void getVerticalOrder(Node root, int hd,
                                 TreeMap<Integer,Vector<Integer>> m)
    {
        if(root == null) return;

        Vector<Integer> vec =  m.getOrDefault(hd, new Vector<>());

        vec.add(root.key);
        m.put(hd, vec);

        getVerticalOrder(root.left, hd-1, m);
        getVerticalOrder(root.right, hd+1, m);
    }
    static void printVerticalOrder(Node root)
    {
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();

        getVerticalOrder(root,0,m);

        for (Map.Entry<Integer, Vector<Integer>> entry : m.entrySet())
            System.out.println(entry.getValue());
    }
}
