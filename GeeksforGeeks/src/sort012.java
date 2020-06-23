public class sort012 {

    public static void main(String[] args) {
	// write your code here
    }
    public static void sort012(int a[], int n){

        if(n <= 1)   return;

        int mid = 0, lb = 0, ub = n-1;
        while(mid <= ub)
        {
            switch(a[mid])
            {
                case 0:
                    swap(a, mid, lb);
                    mid++; lb++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(a, mid, ub);
                    ub--;
            }
        }

        // count sort
        // int[] cnt = new int[3];
        // for(int i : a)
        //     cnt[i]++;

        // for(int i = 1; i < 3; i++)
        //     cnt[i] += cnt[i-1];

        // int[] res = new int[a.length];
        // for(int i = 0; i < a.length; i++)
        //     res[--cnt[a[i]]] = a[i];

        // for(int i = 0; i < a.length; i++)
        //     a[i] = res[i];
    }
    public static void swap(int[] a, int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
