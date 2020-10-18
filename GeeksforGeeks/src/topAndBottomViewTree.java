import java.util.*;
/*
Top View of Binary Tree: https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
 Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
 */
public class topAndBottomViewTree {
    static class Node
    {
        int data;
        Node left, right;
        int hd;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    // function should print the topView of the binary tree
    static TreeMap<Integer, int[]> m;
    static void fillMap(Node root, int d, int l)
    {
        if(root == null) return;

        if(m.get(d) == null)
            m.put(d, new int[]{root.data, l});
        else if(m.get(d)[1] > l)
            m.put(d, new int[]{root.data, l});

        fillMap(root.left, d - 1, l + 1);
        fillMap(root.right, d + 1, l + 1);
    }
    static void topView(Node root)
    {
        m = new TreeMap<>();
        fillMap(root, 0, 0);

        for (Map.Entry<Integer,int[]> entry : m.entrySet())
            System.out.print(entry.getValue()[0] + " ");
    }
    // second approach
    static void topView_v1(Node root)
    {
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Integer> hd = new HashMap<>();
        TreeMap<Integer, Integer> topV = new TreeMap<>();

        q.add(root);
        hd.put(root, 0);

        topV.put(0, root.data);

        while(!q.isEmpty())
        {
            int n = q.size();

            for(int i = 0; i < n; i++)
            {
                Node at = q.remove();
                int d = hd.get(at);

                if(at.left != null) {
                    q.add(at.left);
                    hd.put(at.left, d-1);
                    if(!topV.containsKey(d-1))
                        topV.put(d-1, at.left.data);
                }
                if(at.right != null) {
                    q.add(at.right);
                    hd.put(at.right, d+1);
                    if(!topV.containsKey(d+1))
                        topV.put(d+1, at.right.data);
                }
            }
        }

        for(int k : topV.keySet())
            System.out.print(topV.get(k)+" ");
    }

    static void bottomView(Node root)
    {
        if (root == null)
            return;

        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<Node>();

        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty())
        {
            Node temp = queue.remove();
            hd = temp.hd;

            // find a node having same horizontal distance -> replace
            map.put(hd, temp.data);

            if (temp.left != null)
            {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            if (temp.right != null)
            {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
    }
}

