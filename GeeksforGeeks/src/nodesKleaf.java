import java.util.*;

public class nodesKleaf {
    public static void main(String[] args)
    {
    }

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    ArrayList<Integer> res;
    public ArrayList<Integer> btWithKleaves(Node root, int k)
    {
        res = new ArrayList<>();
        getNleaf(root, k);
        if(res.isEmpty()) res.add(-1);
        return res;
    }
    int getNleaf(Node t, int k)
    {
        if(t == null) return 0;
        if(t.left == null && t.right == null)
            return 1;

        int n = getNleaf(t.left,k)+
                getNleaf(t.right,k);

        if(n == k)
            res.add(t.data);

        return n;
    }
}

