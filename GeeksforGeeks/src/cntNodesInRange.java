import java.util.*;

public class cntNodesInRange {
    public static int getCountOfNode(Node t,int l, int h)
    {
        if(t == null) return 0;
        return (l<=t.data && t.data <= h ? 1 : 0) +
                getCountOfNode(t.left,l,h) +
                getCountOfNode(t.right,l,h);
    }
}
