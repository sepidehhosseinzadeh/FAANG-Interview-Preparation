import java.util.*;
// https://codeforces.com/contest/1451/problem/C
public class canChangeTonext {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt(), k = scanner.nextInt();
            scanner.nextLine();
            char[] a = scanner.nextLine().toCharArray();
            char[] b = scanner.nextLine().toCharArray();

            int[] c = new int[26];

            for (char ch : a) c[ch - 'a']++;
            for (char ch : b) c[ch - 'a']--;

            boolean No = false;
            for (int i = 0; i+1 < 26; i++) {
                if(c[i] < 0 || c[i]%k != 0) No = true; // #b > #a -> we cannot pass these remaining chars to next, can only change to next char.
                // c[i]%k != 0 then no, becuz we can change chars by groups of k
                c[i+1] += c[i]; // pass the rest to next
                if(No) break;
            }
            if(c[25] != 0) No = true;
            System.out.println(No ? "No" : "Yes");
        }
    }
}
