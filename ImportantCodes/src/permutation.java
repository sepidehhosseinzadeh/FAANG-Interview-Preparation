public class permutation {
     class Solution {
        int[][] res;
        int row;

        public int[][] permute(int[] A) {
            int n = A.length;
            row = 0;
            res = new int[fac(n)][n];
            perm(0, n, A);
            return res;
        }

        void perm(int at, int n, int[] arr)
        {
            if (at == n) {
                int j = 0;
                for (int ii : arr)
                    res[row][j++] = ii;
                row++;
                System.out.print(res[0][0] + " ");
                return;
            }
            for (int i = at + 1; i < n; i++) {
                swap(at, i, arr);
                perm(at + 1, n, arr);
                swap(at, i, arr);
            }

        }

        void swap(int i, int j, int[] arr)
        {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        int fac(int n)
        {
            int ans = 1;
            for (int i = 1; i <= n; i++) ans *= i;
            return ans;
        }

    }
}
