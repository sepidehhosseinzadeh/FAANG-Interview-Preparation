import java.util.*;

public class largestBstInBT {
    static int MAX = 1000000 + 1;
    static int MIN = -1;

    // Return the size of the largest sub-tree which is also a BST
    private static class info {
        int max, min;
        int nMaxBst;
        boolean isBst;

        info(int ma, int mi, int nm, boolean is)
        {
            max = ma;
            min = mi;
            nMaxBst = nm;
            isBst = is;
        }
    }

    static int largestBst(Node root)
    {
        info res = nBst(root);
        return res.nMaxBst;
    }

    static info nBst(Node root)
    {
        if (root == null) return new info(MIN, MAX, 0, true);

        if (root.left == null && root.right == null)
            return new info(root.data, root.data, 1, true);

        info l = nBst(root.left);
        info r = nBst(root.right);

        info at = new info(MIN, MAX,
                Math.max(l.nMaxBst, r.nMaxBst), false);

        if (l.isBst && r.isBst && l.max < root.data &&
                r.min > root.data)
        {
            at.isBst = true;
            at.max = Math.max(l.max, Math.max(r.max, root.data));
            at.min = Math.min(l.min, Math.min(r.min, root.data));
            at.nMaxBst = l.nMaxBst + r.nMaxBst + 1;
        }

        return at;
    }
}