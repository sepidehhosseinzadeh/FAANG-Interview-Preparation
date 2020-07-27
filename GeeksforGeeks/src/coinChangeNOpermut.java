import java.util.*;
import java.lang.*;

/*
Given a value N, if we want to make change for N cents,
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change?

--> The order of coins doesn’t matter.

 */
class coinChangeNOpermut {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            System.out.println(ways(n));
        }
    }
    static int ways(int n)
    {
        int[] c = new int[]{3,5,10};
        int[] cnt = new int[n+1];
        cnt[0] = 1;

        for(int i = 0; i < 3; i++)
            for(int j = c[i]; j <= n; j++)
                cnt[j] += cnt[j-c[i]];

//        for(int i = 3; i < n+1; i++)
//            cnt[i] += cnt[i-3];
//        for(int i = 5; i < n+1; i++)
//            cnt[i] += cnt[i-5];
//        for(int i = 10; i < n+1; i++)
//            cnt[i] += cnt[i-10];

        return cnt[n];
    }
}
/* Note: The tricky part is that question has asked for combinations not permutations
If only permutations were asked, we could have simply done dp[i]=dp[i-3]+dp[i-5]+dp[i-10],
as it does not care about the duplicate sets.

Now to avoid that,
1) first mark all values which can be made by moving 3.
eg. if n=8, all values that can be made using only 3 coins are multiple of 3.
Technically we write it as dp[i]=d[i]+dp[i-3].

2)Now moves using 3 are done, mark all moves by moving 5,
This gives us all combinations that can be made using only 3 and 5.
Technically we write it as dp[i]=dp[i]+dp[i-5].

3)Now moves using 3 and 5 are done, mark all moves by moving 10,
This gives us all combinations that can be made using 3, 5 and 10
(note that we would never come across duplicated in such a case)
Technically we write it as dp[i]=dp[i]+dp[i-10].
 */