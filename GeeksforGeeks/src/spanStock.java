import java.util.*;

public class spanStock {
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> idx = new Stack<>();
        int[] span = new int[n];
        for (int i = 0; i < n; i++) {
            while (!idx.isEmpty() && price[idx.peek()] <= price[i]) idx.pop();

            span[i] = idx.isEmpty() ? i + 1 : i - idx.peek();

            idx.add(i);
        }
        return span;
    }
}
class StockSpanner {

    Stack<Integer> idx;
    Stack<Integer> val;
    int day;
    public StockSpanner() {
        idx = new Stack<>();
        val = new Stack<>();
        day = 0;
    }

    public int next(int price) {
        day++;
        while(!val.isEmpty() && val.peek() <= price) {val.pop();idx.pop();}

        int span = val.isEmpty() ? day : day-idx.peek();

        val.add(price);
        idx.add(day);

        return span;
    }
}