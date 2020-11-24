import java.util.*;

public class bitCnt1n {
    public int[] countBits(int num) {
        int[] bitCnt = new int[num+1];
        for(int i = 0; i <= num; i++)
            bitCnt[i] = bitCnt[i >> 1] + (i&1);
        //bitCnt[i] = bitCnt[i/2]+i%2;
        return bitCnt;
    }
}
