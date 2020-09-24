import javax.crypto.NullCipher;
import javax.swing.*;
import java.nio.file.NotDirectoryException;
import java.sql.Array;
import java.util.*;

public class createTree {

    static class Node
    {
        int data;
        Node left, right;
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(createTree(arr, n));
        }
    }

    /*
    1
7 -1 0 0 1 1 3 5
     */
    public static Node createTree(int arr[], int n)
    {
        Node root = null;
        if (n == 0) return root;

        root = new Node(0);
        if (n == 1) return root;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            ArrayList<Integer> cur = map.getOrDefault(arr[i], new ArrayList<>());
            cur.add(i);
            map.put(arr[i], cur);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node at = q.remove();
            int at_idx = at.data;

            if(!map.containsKey(at_idx)) continue;

            ArrayList<Integer> child = map.get(at_idx);

            at.left = new Node(child.get(0));
            q.add(at.left);

            if (child.size() == 1) continue;

            at.right = new Node(child.get(1));
            q.add(at.right);

        }

        return root;
    }
    static Node root;
    public static Node createTree_Opt(int arr[], int n)
    {
        root = null;
        Node[] create = new Node[n];
        for(int i = 0; i < n; i++) create[i] = null;

        for(int i = 0; i < n; i++)
            createNode(arr, i, create);
        return root;
    }
    static void createNode(int[] parent, int at, Node[] created)
    {
        if(created[at] != null) return;

        created[at] = new Node(at);
        if(parent[at] == -1)
        {
            root = created[at];
            return;
        }
        if(created[parent[at]] == null)
            createNode(parent, parent[at], created);

        Node p = created[parent[at]];
        if(p.left == null)
            p.left = created[at];
        else
            p.right = created[at];
    }
}

/*
1
42
3 19 1 41 35 29 27 11 17 23 9 15 33 13 39 23 19 25 21 1 33 15 31 21 5 7 37 29 7 11 31 39 -1 27 3 9 25 17 13 41 37 35

 */