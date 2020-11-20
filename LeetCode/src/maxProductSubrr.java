import java.util.*;

class maxProductSubArr {
    /*Its all about having odd or even numbers of negative integers.
    if the negative numbers are even, then the first pass will give the solution.
    If the negative numbers are odd, the second pass will give the solution.*/
    public int maxProduct_v0(int[] nums) {
        int prod = 1;
        int result = nums[0];

        for(int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0) prod = 1;
        }

        prod = 1;
        for(int i = nums.length - 1; i >= 0; i--) {

            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0) prod = 1;
        }

        return result;
    }

    /*
    Why can we get the max by calculating the products from start and end:
    First, consider there is no zero, and if we get the products of all the numbers:
        1) We will have a negative result if there are odd numbers of negative -> divide the arr to two subarr and max on both -> max (product of first elem to last negative, product of last negative to last elem)
        2) We will have a positive result if there are even numbers of negative -> product of all the numbers

    Above all, we can get the max by going through the array from both start and end, then we won't miss any situations

    If there is a zero, that means we would have subproblems.

    If A[i : j](i != 0, j != n) and the product of elements inside is P. Take P > 0 for example: if A[i] > 0 OR A[j] > 0, then obviously, we should extend this subarray to include A[i] OR A[j] (the negative num (assume A[i]) is excluded, meaning that A[i+1...j] which is covered); if both A[i] and A[j] are negative, then extending this subarray to include both A[i] and A[j] to get a larger product.
    */
    public int maxProduct_v0_combined(int[] A) {
        int n = A.length;
        int max = A[0];
        int l = 0, r = 0;
        for(int i = 0; i < n; i++)
        {
            l = (l==0?1:l)*A[i];
            r = (r==0?1:r)*A[n-1-i];
            max = Math.max(max, Math.max(l,r));
        }
        return max;
    }

    public int maxProduct_v1(int[] A) {
        int n = A.length;
        int max = A[0], maxi = A[0], mini = A[0];
        for (int i = 1; i < n; i++) {

            if (A[i] < 0) { // swap max and min
                int t=maxi; maxi=mini; mini=t;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            mini = Math.min(A[i], A[i] * mini);
            maxi = Math.max(A[i], A[i] * maxi);

            max = Math.max(max, maxi);
        }
        return max;
    }

    public static int maxProduct_v1_1(int[] A) {
        int n = A.length;
        int max = A[0], maxi = A[0], mini = A[0];
        for (int i = 1; i < n; i++) {
            // candidates = (A[i], imax * A[i], imin * A[i])
            // imax = max(candidates)
            // imin = min(candidates)
            int a = A[i];
            int b = A[i] * maxi;
            int c = A[i] * mini;
            mini = Math.min(a, Math.min(b,c));
            maxi = Math.max(a, Math.max(b,c));
            max = Math.max(max, maxi);
        }
        return max;
    }

}