import java.util.*;

public class maxContainerHistogram {
    public static void main(String[] args)
    {
        System.out.print(maxArea(new int[]{1,5,4,3}, 4));
    }
    static long maxArea(int[] bar, int n) {
        Stack<Integer> s = new Stack<>();

        int maxArea = 0;
        for(int i = 0; i < n; i++)
        {
            while(!s.isEmpty() && bar[i] > bar[s.peek()])
                maxArea = Math.max(maxArea,
                        Math.abs((i-s.peek())*bar[s.pop()]));
            s.add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        int maxIdx = -1;
        while(!s.isEmpty()) {
            maxIdx = s.peek();
            q.add(s.pop());
        }
        while(!q.isEmpty()) {
            int max = q.remove();
            maxArea = Math.max(maxArea,
                    Math.abs((max-maxIdx)*bar[max]));
        }

        return maxArea;
    }
}
