import java.util.*;

public class bitReverse {
    // you need treat n as an unsigned value
    public int reverseBits_(int n) {
        int mask = 1 << 31, res = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) != 0) res |= mask;
            mask >>= 1;
            n >>= 1;
        }
        return res;
    }

    public int reverseBits(int n) {
        int mask = 1, res = 0;
        for (int i = 0; i < 32; ++i) {
            res <<= 1;
            if ((mask & n) != 0) res |= 1;
            mask <<= 1;
        }
        return res;
    }
}