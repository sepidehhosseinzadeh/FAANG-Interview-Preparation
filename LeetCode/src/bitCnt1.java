import java.util.*;

public class bitCnt1 {
    // you need to treat n as an unsigned value
    public int hammingWeight_v0(int n) {
        int cnt = 0;
        while(n != 0) // NOT n>0 becuz unsigned
        {
            cnt += (n&1);
            n = n >>> 1; // use bit shifting unsigned operation >>> (while >> depends on sign extension)
        }
        return cnt;
    }

    public int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            n = n&(n-1);
            cnt++;
        }
        return cnt;
    }
}
