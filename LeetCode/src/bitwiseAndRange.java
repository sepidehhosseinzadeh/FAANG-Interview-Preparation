import java.util.*;

public class bitwiseAndRange {
    public int rangeBitwiseAnd(int m, int n) {
        int lenOfZero = 0;
        while(m != n) // until they are not equal, shift right
        {
            m >>= 1;
            n >>= 1;
            lenOfZero++;
        }
        return m << lenOfZero; // the right part that are not equal should be zero
    }
}
