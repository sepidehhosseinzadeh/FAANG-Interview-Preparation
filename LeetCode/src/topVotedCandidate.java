import java.util.*;
/*
In an election, the i-th vote was cast for persons[i] at time times[i].
Now, we would like to implement the following query function:
TopVotedCandidate.q(int t) will return the id of the person that was leading the election at time t.
Votes cast at time t will count towards our query.
In the case of a tie, the most recent vote (among tied candidates) wins.
Example:

Input: ["TopVotedCandidate","q","q","q","q","q","q"],
[[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
Explanation:
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.
 */
class TopVotedCandidate {
    int[] top;
    int[] t;

    public TopVotedCandidate(int[] p, int[] t) {
        top = new int[p.length];
        this.t = t;
        int[] cnt = new int[p.length + 1];
        int lead = p[0];

        for (int i = 0; i < p.length; i++) {
            cnt[p[i]]++;
            if (cnt[p[i]] >= cnt[lead])
                lead = p[i];
            top[i] = lead;
        }
    }

    public int q(int qt) {
        int lb = 0, ub = t.length;

        while (lb < ub) {
            int midTi = lb + (ub - lb) / 2;

            if (t[midTi] <= qt)
                lb = midTi + 1;
            else
                ub = midTi;
        }
        return top[lb - 1];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */

