import java.util.*;

// Given a preorder traversal of a BST,
// print the leaf nodes of the tree without building the tree
public class leafsBSTPreorder {
    static void leafPreorder(int l, int r, int[] arr)
    {
        if(l > r) return;
        if(l == r)
        {
            System.out.print(arr[l]+" ");
            return;
        }
        int mid = l+1;
        while(mid <= r && arr[mid] <= arr[l]) mid++;

        leafPreorder(l+1, mid-1, arr);
        leafPreorder(mid, r, arr);
    }
}
