import java.util.*;

public class ContinuousMedian {
    /*: Numbers are randomly generated and passed to a method. Write a program
        to find and maintain the median value as new values are generated.
     */
    private static PriorityQueue<Integer> leftOfMed =
            new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> rightOfMed =
            new PriorityQueue<>();
    private static double median = Integer.MIN_VALUE;
    public static void main(String[] args)
    {
        int[] randomInt = new int[] {1, 3, 2, 2, 5, 5, -1, 3, 2, 5, 6, 7};
        for(int i : randomInt)
        {
            getMedian_v1(i);
            System.out.println(median);
        }
    }
    static void getMedian(int val)
    {
        if(median == Integer.MIN_VALUE)
            leftOfMed.add(val);
        else if(val <= median)
            leftOfMed.add(val);
        else
            rightOfMed.add(val);

        int l = leftOfMed.size(), r = rightOfMed.size();
        if(l == r)
            median = (leftOfMed.peek()+rightOfMed.peek())/2.0;
        else if(l > r)
            median = leftOfMed.peek();
        else
            median = rightOfMed.peek();

        System.out.println(leftOfMed);
        System.out.println(rightOfMed);
    }

    // Building a balance-tree like structure by max-heap nad min-heap
    static void getMedian_v1(int val)
    {
        int l = leftOfMed.size(), r = rightOfMed.size();
        if(l == r)
        {
            if(rightOfMed.size() != 0 && val > rightOfMed.peek())
            {
                leftOfMed.add(rightOfMed.poll());
                rightOfMed.add(val);
            }
            else
                leftOfMed.add(val);
        }
        else // left has one more
        {
            if(leftOfMed.size() != 0 && val < leftOfMed.peek())
            {
                rightOfMed.add(leftOfMed.poll());
                leftOfMed.add(val);
            }
            else
                rightOfMed.add(val);
        }

        l = leftOfMed.size(); r = rightOfMed.size();

        if(l == r)
            median = (leftOfMed.peek()+rightOfMed.peek())/2.0;
        else if(l > r)
            median = leftOfMed.peek();

        System.out.println(leftOfMed);
        System.out.println(rightOfMed);
    }


}
