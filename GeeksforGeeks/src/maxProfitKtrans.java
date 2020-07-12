import java.util.*;

public class maxProfitKtrans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int K = sc.nextInt();
            int n = sc.nextInt();

            int[] p = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = sc.nextInt();

            System.out.println(maxProfDP(K, p));
        }
    }

    static int maxProfDP(int K, int[] p)
    {
        int n = p.length;
        int[][] maxProf = new int[n][K+1];

        for(int k = 1; k <= K; k++)
            for(int i = 1; i < n; i++)
            {
                if(k == 0)
                {maxProf[i][k] = maxProf[i-1][k]; continue;}

                int maxP = 0;
                for(int j = 0; j < i; j++)
                    maxP = Math.max(maxP, maxProf[j][k-1]+p[i]-p[j]);

                maxProf[i][k] = Math.max(maxProf[i-1][k], maxP);
            }

        return maxProf[n-1][K];

    }
    static int maxProfDPOpti(int K, int[] p)
    {
        int n = p.length;
        int[][] maxProf = new int[n][K+1];

        for(int k = 1; k <= K; k++)
        {
            int preMaxProf = Integer.MIN_VALUE;
            for(int i = 1; i < n; i++)
            {
                if(k == 0)
                {maxProf[i][k] = maxProf[i-1][k]; continue;}

                preMaxProf = Math.max(preMaxProf, maxProf[i-1][k-1]-p[i-1]);

                maxProf[i][k] = Math.max(maxProf[i-1][k], preMaxProf+p[i]);
            }
        }

        return maxProf[n-1][K];

    }
}