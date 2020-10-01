import java.util.*;

/*
Construct Binary Tree from Parent Array
Given an array of size N that represents a Tree in such a way that array indexes are values in tree nodes
and array values give the parent node of that particular index (or node).
The value of the root node index would always be -1 as there is no parent for root.
Construct the linked representation of Binary Tree from this array representation.
Input:
N = 7
parent[] = {-1,0,0,1,1,3,5}
Output: 0 1 2 3 4 5 6
Explanation:For the array parent[] = {-1,
0, 0, 1, 1, 3, 5}; the tree generated
will have a sturcture like
         0
       /   \
      1     2
     / \
    3   4
   /
  5
/
6
 */
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
            p.left = created[at]; // NOT new Node(at)!
        else
            p.right = created[at];
    }
}

/*
2
42
3 19 1 41 35 29 27 11 17 23 9 15 33 13 39 23 19 25 21 1 33 15 31 21 5 7 37 29 7 11 31 39 -1 27 3 9 25 17 13 41 37 35
7
-1 0 0 1 1 3 5
 */