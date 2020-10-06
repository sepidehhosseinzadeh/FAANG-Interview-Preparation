import java.util.*;

public class LeafOfPreOrderBST {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            leafOfPreBST(arr, 0, n-1);
            System.out.println();
        }
    }
    static void leafOfPreBST(int[] preorder, int lb, int ub)
    {
        if(lb > ub) return;
        if(lb == ub)
        {
            System.out.print(preorder[lb]+" ");
            return;
        }

        int ri = lb+1;
        while(ri <= ub && preorder[ri] <= preorder[lb]) ri++;

        leafOfPreBST(preorder, lb+1, ri-1);
        leafOfPreBST(preorder, ri, ub);
    }
}
