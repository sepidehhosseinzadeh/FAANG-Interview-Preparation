import java.util.*;

public class sortRelativeTo {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int[] rel = new int[m];
            for(int i = 0; i < m; i++)
                rel[i] = sc.nextInt();

            sort(arr, rel);
            for(int i = 0; i < arr.length; i++)
                System.out.print(arr[i]+(i<n-1?" ":"\n"));

        }
    }

    static void sort(int[] arr, int[] rel1)
    {
        HashMap<Integer, Integer> rel = new HashMap<>();
        for(int i = 0; i < rel1.length; i++)
            rel.put(rel1[i], i);

        Qsort(0, arr.length-1, arr, rel);
        // Arrays.sort(arr, new Comparator<Integer>(){
        //     @Override
        //     public int compare(int a, int b)
        //     {
        //         return compare(a,b,rel);
        //     }
        // });
    }
    static void Qsort(int st, int en, int[] arr,
                      HashMap<Integer, Integer> rel)
    {
        if(st < en)
        {
            int idx = partition(arr, st, en, rel);
            Qsort(st, idx-1, arr, rel);
            Qsort(idx+1, en, arr, rel);
        }
    }
    // 	static int partition(int arr[], int start, int end,
// 	                            HashMap<Integer, Integer> rel)
//     {
// 		int pivot = arr[end];
// 		int pIndex = start;
// 		for (int i = start; i < end; i++) {
// 			if (compare(pivot, arr[i], rel) >= 0) {
// 				swap(i, pIndex, arr);
// 				pIndex++;
// 			}
// 		}
// 		swap(pIndex, end, arr);
// 		return pIndex;
// 	}
    static int partition(int[] arr, int st, int en,
                         HashMap<Integer, Integer> rel)
    {
        int i = st, j = en, pivot = en;
        while(i < j)
        {
            while(i < j && compare(arr[i],arr[pivot],rel) < 0) i++;
            while(i < j && compare(arr[j],arr[pivot],rel) >= 0) j--;

            if (i < j)
                swap(i,j,arr);
        }
        swap(i,pivot,arr);
        return i;

    }
    static void swap(int i, int j, int[] arr)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    static int compare(int a, int b, HashMap<Integer, Integer> rel)
    {
        int a_i = rel.containsKey(a) ? rel.get(a) : -1;
        int b_i = rel.containsKey(b) ? rel.get(b) : -1;

        if(a_i != -1 && b_i != -1)
            return a_i-b_i;
        else if(b_i != -1)
            return 1;
        else if(a_i != -1)
            return -1;
        return a-b;
    }



    //Method 2 (Using Sorting and Binary Search)
    /* A Binary Search based function to find
    index of FIRST occurrence of x in arr[].
    If x is not present, then it returns -1 */
    static int first(int arr[], int low, int high,
                     int x, int n)
    {
        if (high >= low) {
            /* (low + high)/2; */
            int mid = low + (high - low) / 2;

            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
            if (x > arr[mid])
                return first(arr, (mid + 1), high,
                        x, n);
            return first(arr, low, (mid - 1), x, n);
        }
        return -1;
    }

    // Sort A1[0..m-1] according to the order
    // defined by A2[0..n-1].
    static void sortAccording(int A1[], int A2[], int m,
                              int n)
    {
        // The temp array is used to store a copy
        // of A1[] and visited[] is used to mark the
        // visited elements in temp[].
        int temp[] = new int[m], visited[] = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = A1[i];
            visited[i] = 0;
        }

        // Sort elements in temp
        Arrays.sort(temp);

        // for index of output which is sorted A1[]
        int ind = 0;

        // Consider all elements of A2[], find them
        // in temp[] and copy to A1[] in order.
        for (int i = 0; i < n; i++) {
            // Find index of the first occurrence
            // of A2[i] in temp
            int f = first(temp, 0, m - 1, A2[i], m);

            if (f == -1)
                continue;

            // Copy all occurrences of A2[i] to A1[]
            for (int j = f; (j < m && temp[j] == A2[i]);
                 j++) {
                A1[ind++] = temp[j];
                visited[j] = 1;
            }
        }

        // Now copy all items of temp[] which are
        // not present in A2[]
        for (int i = 0; i < m; i++)
            if (visited[i] == 0)
                A1[ind++] = temp[i];
    }
}
/*
/////////Method 3 (Using Self-Balancing Binary Search Tree)
We can also use a self balancing BST like AVL Tree, Red Black Tree, etc.
Following are detailed steps.

Create a self balancing BST of all elements in A1[]. In every node of BST,
also keep track of count of occurrences of the key and a bool field visited
which is initialized as false for all nodes.
Initialize the output index ind as 0.
Do following for every element of A2[i] in A2[]
Search for A2[i] in the BST, if present then copy all occurrences to
A1[ind] and increment ind. Also mark the copied elements visited in the BST node.
Do an inorder traversal of BST and copy all unvisited keys to A1[].
Time Complexity of this method is same as the previous method.
Note that in a self balancing Binary Search Tree, all operations require logm time.

/////////Method 4 (Use Hashing)
Loop through A1[], store the count of every number in a HashMap
(key:number,value:count of number)
Loop through A2[], check if it is present in HashMap,
if so, put in output array that many times and remove the number from HashMap.
Sort the rest of the numbers present in HashMap and put in output array.
Thanks to Anurag Sigh for suggesting this method.

The steps 1 and 2 on average take O(m+n) time under the assumption that
 we have a good hashing function that takes O(1) time for insertion and search
 on average. The third step takes O(p Log p) time where p is
 the number of elements remained after considering elements of A2[].
 */

