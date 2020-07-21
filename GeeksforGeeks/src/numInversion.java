import java.util.*;
import java.lang.*;

class numInversion {
    static class Node
    {
        Node left, right;
        int data;
        int rightSize;
        Node(int data)
        {
            this.data = data;
            rightSize = 0;
            left = right = null;
        }
    }
    static long inversion;
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

            inversion = 0;
            Node root = null;
            for(int i = 0; i < n; i++)
                root = buildBST(root, arr[i]);

            //bubbleSort(arr, n);
            System.out.println(inversion);

        }
    }

    // O(log(n) + n) = O(n)
    static Node buildBST(Node root, int val)
    {
        if(root == null)
        {
            root = new Node(val);
            return root;
        }

        if(val >= root.data)
        {
            root.right = buildBST(root.right, val);
            root.rightSize++;
        }
        else
        {
            root.left = buildBST(root.left, val);
            inversion += root.rightSize+1;
        }
        return root;
    }
    // O(n^2)
    static void bubbleSort(int arr[], int n)
    {
        for(int i = 0; i < n; i++)
            for(int j = 1; j < n-i; j++)
                if(arr[j-1] > arr[j])
                {
                    inversion++;
                    int t = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = t;
                }
    }

}