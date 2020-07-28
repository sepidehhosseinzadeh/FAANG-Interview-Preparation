import java.util.*;

public class SegmentTree {
    void constructTree(int[] input, int[] segTree, int low, int high, int pos)
    {
        if (low == high) {
            segTree[pos] = input[low];
            return;
        }

        int mid = (low + high) / 2;
        constructTree(input, segTree, low, mid, 2 * pos + 1);
        constructTree(input, segTree, mid + 1, high, 2 * pos + 2);
        segTree[pos] = Math.min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
    }
    void updateTree(int new_val, int new_val_idx, int[] segTree, int low, int high, int pos) {
        if (low == high) {
            segTree[pos] = new_val;
            return;
        }

        int mid = (low + high) / 2;
        if (new_val_idx <= mid)
            updateTree(new_val, new_val_idx, segTree, low, mid, pos*2);
        else
            updateTree(new_val, new_val_idx, segTree, mid+1, high, pos*2+1);
        segTree[pos] = Math.min(segTree[pos * 2], segTree[pos * 2 + 1]);
    }

    int rangeMinQuery(int[] input, int[] segTree, int qlow, int qhigh,
                      int low, int high, int pos)
    {
        if (low >= qlow && high <= qhigh)
            return segTree[pos];
        else if (low < qlow || high > qhigh)
            return Integer.MAX_VALUE;

        int mid = (low + high) / 2;
        return Math.min(
                rangeMinQuery(input, segTree, qlow, qhigh, low, mid, 2 * pos + 1),
                rangeMinQuery(input, segTree, qlow, qhigh, mid + 1, high, 2 * pos + 2));
    }


}
