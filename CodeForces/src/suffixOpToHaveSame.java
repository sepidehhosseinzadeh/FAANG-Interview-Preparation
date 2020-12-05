import java.util.*;
// sol: https://codeforces.com/blog/entry/85288
public class suffixOpToHaveSame {
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
            solve();
        sc.close();
    }

    public static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        long ans = 0;
        for (int i = 2; i <= n; i++) // actual cost to have all nums equals
            ans += Math.abs(a[i] - a[i - 1]);

        int mx = Math.max(Math.abs(a[1] - a[2]), Math.abs(a[n] - a[n - 1])); // special case
        for (int i = 2; i < n; i++) // Gildong has to perform one or more 2-nd operations on the suffix starting at 𝑎𝑖,
            // and then one or more 1-st operations on the suffix starting at 𝑎𝑖+1
            // to compensate for the extra 2-nd operations. This applies to the scenario where 𝑎𝑖−1>𝑎𝑖<𝑎𝑖+1 as well. If 𝑎𝑖 is between 𝑎𝑖−1 and 𝑎𝑖+1,
            // these additional operations are unnecessary. In fact, the number of operations is decreased from 𝑎𝑏𝑠(𝑎𝑖−𝑎𝑖−1)+𝑎𝑏𝑠(𝑎𝑖+1−𝑎𝑖) to 𝑎𝑏𝑠(𝑎𝑖+1−𝑎𝑖−1)
            mx = Math.max(mx, Math.abs(a[i] - a[i - 1]) +
                    Math.abs(a[i + 1] - a[i]) - Math.abs(a[i + 1] - a[i - 1]));

        System.out.println(ans - mx);
    }
}
