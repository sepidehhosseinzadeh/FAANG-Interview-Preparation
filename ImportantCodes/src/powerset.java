import java.util.*;

public class powerset {
    class Solution {
        public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
            Collections.sort(A);
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            powerSet(0, 0, A, res);

            Collections.sort(res, new Comparator<ArrayList<Integer>>() {
                public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                    int i = 0, j = 0;
                    while (i < a.size() && j < b.size() && a.get(i) == b.get(j)) {
                        i++;
                        j++;
                    }

                    if (i == a.size() && j == b.size())
                        return 0;
                    if (i == a.size())
                        return -1;
                    if (j == b.size())
                        return 1;

                    return a.get(i) > b.get(j) ? 1 : -1;
                }
            });
            return res;
        }

        void powerSet(int at, int bits, ArrayList<Integer> A,
                      ArrayList<ArrayList<Integer>> res)
        {
            if (at == A.size()) {
                ArrayList<Integer> curr = new ArrayList<Integer>();
                for (int i = 0; i < A.size(); i++)
                    if ((bits & (1 << i)) != 0)
                        curr.add(A.get(i));

                res.add(curr);
                return;
            }
            bits |= (1 << at);
            powerSet(at + 1, bits, A, res);

            bits &= ~(1 << at);
            powerSet(at + 1, bits, A, res);


        }
    }
}
