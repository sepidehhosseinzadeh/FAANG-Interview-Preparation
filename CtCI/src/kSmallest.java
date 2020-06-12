import java.util.*;

public class kSmallest {
    public static void main(String[] args)
    {
        int[] arr = new int[] {9,8,7,6,5,4,2,10,1};
        System.out.println(Arrays.toString(getKsmallest(arr, 0, arr.length-1, 6)));
    }

    public static int[] getKsmallest(int[] arr, int lb, int ub, int k)
    {
        if(lb > ub) return null;
        int pivot = partition(arr, lb, ub);
        if(pivot == k)  return copyArray(arr, 0, pivot);
        else if(pivot > k) return getKsmallest(arr, lb, pivot, k);
        return getKsmallest(arr, pivot, ub, k-pivot);
    }
    static int partition(int[] arr, int lb, int ub)
    {
        if(lb > ub) return -1;
        if(lb == ub) return lb;

        int pivot = lb+(ub-lb)/2;
        int i = lb, j = ub;
        while (i < j)
        {
            while(i < j && arr[i] < arr[pivot]) i++;
            while(i < j && arr[j] >= arr[pivot]) j--;

            swap(arr, i,j);
        }
        swap(arr, pivot, j);
        return pivot;
    }
    static void swap(int[] arr, int i, int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    static int[] copyArray(int[]arr, int lb, int ub)
    {
        int[] res = new int[ub-lb+1];
        for(int i = lb; i <= ub; res[i-lb] = arr[i], i++);
        return res;
    }
}
