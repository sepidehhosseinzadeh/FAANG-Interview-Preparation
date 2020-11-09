import java.util.*;

public class delCharToHaveUniqCnt {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        Arrays.sort(cnt);

        int res = 0;
        var set = new HashSet<Integer>();
        for (int i = 25; i - 1 >= 0; i--) {
            if (cnt[i] > 0) set.add(cnt[i]);
            while (cnt[i - 1] > 0 && set.contains(cnt[i - 1])) {
                cnt[i - 1]--;
                res++;
            }
        }
        return res;
    }
}
