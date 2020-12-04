import java.util.*;

public class intervalInsertMerge {
    public int[][] insert(int[][] intv, int[] newIntv) {
        // sorted by starting val
        var res = new ArrayList<int[]>();
        int i = 0, n = intv.length;
        int[] cur = newIntv.clone();
        while (i < n) {
            if (cur[0] > intv[i][1]) {
                res.add(intv[i].clone());
            }
            else if (cur[1] >= intv[i][0]) {
                int lb = Math.min(cur[0], intv[i][0]);
                int ub = Math.max(cur[1], intv[i][1]);
                cur = new int[]{lb, ub};
            }
            else {
                res.add(cur.clone());
                cur = intv[i].clone();
            }
            i++;
        }
        res.add(cur);

        int[][] ret = new int[res.size()][2];
        int j = 0;
        for (int[] v : res) ret[j++] = v;

        return ret;
    }
    // another approach
    // List<Interval> insert_(List<Interval> intervals, Interval newInterval) {
    //     List<Interval> result = new LinkedList<>();
    //     int i = 0;
    //     // add all the intervals ending before newInterval starts
    //     while (i < intervals.size() && intervals.get(i).end < newInterval.start)
    //         result.add(intervals.get(i++));
    //     // merge all overlapping intervals to one considering newInterval
    //     while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
    //         newInterval = new Interval( // we could mutate newInterval here also
    //                 Math.min(newInterval.start, intervals.get(i).start),
    //                 Math.max(newInterval.end, intervals.get(i).end));
    //         i++;
    //     }
    //     result.add(newInterval); // add the union of intervals we got
    //     // add all the rest
    //     while (i < intervals.size()) result.add(intervals.get(i++));
    //     return result;
    // }
}