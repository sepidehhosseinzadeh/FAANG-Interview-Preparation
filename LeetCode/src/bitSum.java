import java.util.*;

public class bitSum {
    // XOR is acting as sum, and & << is passing the carry to the left bit.
    // Repeat until no carry left
    public int getSum_(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
    public int getSubtract_(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }

    public int getSum(int a, int b) {
        return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
    }

    public int getSubtract(int a, int b) {
        return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
    }

    // Get negative number
    public int negate(int x) {
        return ~x + 1;
    }
}
