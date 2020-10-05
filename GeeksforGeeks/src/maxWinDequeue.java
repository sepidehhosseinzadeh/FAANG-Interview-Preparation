import java.util.*;
import java.lang.*;

class maxWinDequeue {
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
    static int[] maxSlidingWindow(int[] arr, int k) {
        int[] res = new int[arr.length-k+1];
        
        Deque<Integer> dq = new ArrayDeque<>();
	    
        int j = 0;
	    for(int i = 0; i < arr.length; i++)
	    {
	        while(!dq.isEmpty() && dq.peek() <= i-k)
	            dq.remove();
	           
	        while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
	            dq.removeLast();
	        
	        dq.add(i);
	        
	        if(i >= k-1)
	            res[j++] = arr[dq.peek()];
	    }
        
        return res;
    }
}
