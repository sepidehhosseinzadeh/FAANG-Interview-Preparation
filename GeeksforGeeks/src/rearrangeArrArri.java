import java.util.*;

// https://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/
// rearrange so that arr[i] = arr[arr[i]]
public class rearrangeArrArri {
    // Identity function. f(x)=x -> f(f(x))=x. Rearrange 'arr[0..n-1]' so that 'arr[j]'
    // becomes 'i' if 'arr[i]' is 'j'
    void rearrangeNaive(int arr[], int n)
    {
        int temp[] = new int[n];
        for (int i = 0; i < n; i++)
            temp[arr[i]] = i;

        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }
    // O(1) extra space
    static void rearrange(int arr[], int n)
    {
        // First step: Increase all values by (arr[arr[i]]%n)*n
        for (int i = 0; i < n; i++)
            arr[i] += (arr[arr[i]] % n) * n;

        // Second Step: Divide all values by n
        for (int i = 0; i < n; i++)
            arr[i] /= n;
    }
}