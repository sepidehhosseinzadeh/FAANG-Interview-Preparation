import java.util.*;

// Count Number of SubTrees having given Sum
public class cntSubTreewithSum {
    static class Node
    {
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
    
    //HashMap<Integer, Integer> map;
    int cnt;
    int x;
    int countSubtreesWithSumX(Node root, int X)
    {
        //map = new HashMap<>();
        cnt = 0;
        x = X;
        sum(root);

        return cnt; //map.containsKey(X) ? map.get(X) : 0;
    }
    int sum(Node t)
    {
        if(t == null) return 0;

        int s = t.data + sum(t.left) + sum(t.right);

        //int cnt = map.getOrDefault(s, 0)+1;
        //map.put(s, cnt);
        if(s == x) cnt++;

        return s;

    }
}
