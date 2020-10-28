import java.util.*;

// Count Number of SubTrees having given Sum
public class cntSubTreewithSum {
    int cnt;
    int x;
    int countSubtreesWithSumX(Node root, int X)
    {
        cnt = 0;
        x = X;
        sum(root);
        return cnt;
    }
    int sum(Node t)
    {
        if(t == null) return 0;
        int s = t.data + sum(t.left) + sum(t.right);
        if(s == x) cnt++;

        return s;

    }
}
