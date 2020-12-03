import java.util.*;

public class nextGreaterIII {
    // Find a pos i from right which i+1 is greater thatn i.
    // We should swap a smallest and biiger than i value on the right of the i to n (j).
    // then swap these two values i and j.
    // we have a bigger value now. But in order to make it smaller,
    // we can reverse all the i+1 to n.

    public int nextGreaterElement(int nm) {
        char[] num = (nm + "").toCharArray();
        int n = num.length;

        int i = n - 2;
        while (i >= 0 && num[i] >= num[i + 1]) i--;

        if (i < 0) return -1;

        int j = n - 1;
        // we know that all the digits are in decresing order
        while (j >= i && num[i] >= num[j]) j--;

        swap(num, j, i);
        reverse(num, i + 1, n - 1);

        try {
            return Integer.parseInt(new String(num));
        } catch (Exception e) {
            return -1;
        }
    }

    void swap(char[] ch, int i, int j) {
        char t = ch[i]; ch[i] = ch[j]; ch[j] = t;
    }

    void reverse(char[] ch, int l, int r) {
        while (l < r) swap(ch, l++, r--);
    }

}