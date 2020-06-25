import java.util.*;

public class SegmentTree {
    void constructTree(int[] input, int[] segTree, int low, int high, int pos)
    {
        if(low == high)
        {
            segTree[pos] = input[low];
            return;
        }

        int mid = (low+high)/2;
        constructTree(input, segTree, low, mid, 2*pos+1);
        constructTree(input, segTree, mid+1, high, 2*pos+2);
        segTree[pos] = Math.min(segTree[2*pos+1], segTree[2*pos+2]);
    }
    int rangeMinQuery(int[] input, int[] segTree, int qlow, int qhigh,
                                                 int low, int high, int pos)
    {
        if(low >= qlow && high <= qhigh)
            return segTree[pos];
        else if(low < qlow || high > qhigh)
            return Integer.MAX_VALUE;

        int mid = (low+high)/2;
        return Math.min(
            rangeMinQuery(input, segTree, qlow, qhigh, low, mid, 2*pos+1),
            rangeMinQuery(input, segTree, qlow, qhigh, mid+1, high,2*pos+2));
    }
    void update(int[] segTree, int v, int tl, int tr, int pos, int new_val) {
        if (tl == tr) {
            segTree[v] = new_val;
        } else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(segTree,v*2, tl, tm, pos, new_val);
            else
                update(segTree,v*2+1, tm+1, tr, pos, new_val);
            segTree[v] = segTree[v*2] + segTree[v*2+1];
        }
}
