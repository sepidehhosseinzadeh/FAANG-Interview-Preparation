import java.util.*;

public class treeFromInPost {
    static class Node
    {
        int data;
        Node left;
        Node right;

            Node(int value)
        {
            data = value;
            left = null;
            right = null;
        }
    }

    // Function should construct tree and return
    // root of it.  in[] stores inorder traversal
    // post[] stores postorder traversal.  n is
    // size of these arrays

    Node buildTree(int in[], int post[], int n)
    {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < n; i++)
            inMap.put(in[i], i);

        return build(0, n-1, inMap, in, post,
                0,n-1,0,n-1);
    }

    Node build(int l, int h, HashMap<Integer, Integer> inMap,
               int[] in, int[] post,
               int is, int ie, int ps, int pe)
    {
        if(l > h) return null;
        if(l==h) return new Node(in[l]);

        Node root = new Node(post[pe]);

        int i = inMap.get(post[pe]);

        root.left = build(l, i-1, inMap,in,post,
                is, i-1, ps, ps+i-1-is);
        root.right = build(i+1, h, inMap,in,post,
                i+1, ie, ps+i-is, pe-1);

        return root;
    }
}

