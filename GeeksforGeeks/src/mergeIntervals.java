import java.util.*;

class mergeIntervals {
    static class Interval implements Comparable<Interval>
    {
        int st, en;
        Interval(int s, int e)
        {
            st = s; en = e;
        }
        public int compareTo(Interval o)
        {
            return this.st - o.st;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            final int n = sc.nextInt();

            Interval[] intervals = new Interval[n];
            for(int i = 0; i < n; i++)
            {
                int a = sc.nextInt(), b = sc.nextInt();
                intervals[i] = new Interval(a,b);
            }
            Arrays.sort(intervals);
            mergeInterval(intervals, n);
        }
    }
    static void mergeInterval(Interval[] I, int n)
    {
        Stack<Interval> stack = new Stack<>();
        stack.add(I[0]);
        if(n > 1)
            for(int i = 1; i < n; i++)
            {
                if(I[i].st > stack.peek().en)
                    stack.add(I[i]);

                else if(I[i].st <= stack.peek().en)
                {
                    Interval top = stack.pop();
                    top.en = Math.max(top.en, I[i].en);
                    stack.add(top);
                }
            }
        for(Interval i : stack)
            System.out.print(i.st + " " + i.en + " ");
        System.out.println();
    }
}

