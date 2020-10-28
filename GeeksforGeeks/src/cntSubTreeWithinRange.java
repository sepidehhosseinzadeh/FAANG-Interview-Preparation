import java.util.*;

public class cntSubTreeWithinRange {
    static int cnt = 0;
    static boolean isInRange(Node t, int l, int r)
    {
        if(t == null) return true;

        if(l <= t.data && t.data <= r &&
            isInRange(t.left, l,r) && isInRange(t.right, l,r))
        {
            cnt++;
            return true;
        }
        return false;
    }
}
