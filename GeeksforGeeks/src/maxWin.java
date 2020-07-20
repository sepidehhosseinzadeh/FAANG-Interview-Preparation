import java.util.*;
import java.lang.*;

class maxWin {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            final int n = sc.nextInt(), k = sc.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            maxWin_v1(arr, n, k);
            System.out.println();
        }
    }
    // O((k+log(k)) * n) = O(kn)
    static void maxWin_v0(int[] arr, int n, int k)
    {
        PriorityQueue<Integer> curWin = new PriorityQueue<>(
                Collections.reverseOrder());
        for(int i = 0; i < k; i++)
            curWin.add(arr[i]);

        System.out.print(curWin.peek()+" ");
        for(int st = 0; st < n; st++)
        {
            int en = st+k;
            if(en >= n) break;

            curWin.remove(arr[st]);
            curWin.add(arr[en]);

            System.out.print(curWin.peek()+" ");
        }
        System.out.println();
    }
    static void maxWin_v1(int[] arr, int n, int k)
    {
        Deque<Integer> deque = new LinkedList<>();
        // addLast elements, and at the time of moving win removeFirst
        // unuseful elements that are before i-k win because max is at index i
        int i = 0;
        for(; i < k; i++)
        {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i])
                deque.pollLast();
            deque.addLast(i);
        }
        for(; i < n; i++)
        {
            System.out.print(arr[deque.peekFirst()]+" ");

            while (!deque.isEmpty() && deque.peekFirst() <= i-k)
                deque.pollFirst();

            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i])
                deque.pollLast();

            deque.addLast(i);
        }
        System.out.print(arr[deque.peekFirst()]+" ");
    }
    // O(n)
    // A Dequeue (Double ended queue) based method for printing maximum element of
    // all subarrays of size k
    static void maxWin_v1_0(int arr[], int n, int k)
    {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front()] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast(); // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }
}
