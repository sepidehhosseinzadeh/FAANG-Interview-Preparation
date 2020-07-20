import java.util.*;

/*The span Si of the stock’s price on a given day i is defined as
the maximum number of consecutive days just before the given day,
for which the price of the stock on the current day is less than or
equal to its price on the given day.
*/
class stockSpan {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            final int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            span(arr,n);
        }
    }
    static void span(int[] val, int n)
    {
        Stack<Integer> stack = new Stack<>();
        for(int t = 0; t < n; t++)
        {
            while(!stack.isEmpty() && val[stack.peek()] <= val[t])
                stack.pop();
            System.out.print((stack.isEmpty()?t+1:t-stack.peek())+" ");
            stack.add(t);
        }
        System.out.println();

    }
}
