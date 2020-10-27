import java.util.*;

public class printBoundriesBT {
    ArrayList<Integer> res;

    ArrayList<Integer> printBoundary(Node t)
    {
        res = new ArrayList<>();
        if (t == null) return res;

        res.add(t.data);

        leftBound(t.left);
        leafBound(t.left);
        leafBound(t.right);
        rightBound(t.right);

        return res;
    }

    void leftBound(Node t)
    {
        if (t == null) return;

        // why not add the data once here, to make sure it's not leaf
        // print, then go left if not right
        if (t.left != null) {
            res.add(t.data);
            leftBound(t.left);
        }
        else if (t.right != null) {
            res.add(t.data);
            leftBound(t.right);
        }
    }

    void rightBound(Node t)
    {
        if (t == null) return;

        // go right if not left, print last!!!
        if (t.right != null) {
            rightBound(t.right);
            res.add(t.data);
        }
        else if (t.left != null) {
            rightBound(t.left);
            res.add(t.data);
        }
    }

    void leafBound(Node t)
    {
        if (t == null) return;

        leafBound(t.left);
        if (t.left == null && t.right == null)
            res.add(t.data);
        leafBound(t.right);
    }
}
