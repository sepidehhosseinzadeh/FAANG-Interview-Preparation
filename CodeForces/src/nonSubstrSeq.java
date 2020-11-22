import java.util.*;
// https://codeforces.com/contest/1451/problem/B
/*
for(int z=0;z<q;z++) {
    int l,r; cin>>l>>r; l--; r--;
    int pos=0;
    for(int i=0;i<l;i++) {
        if(s[i]==s[l]) pos=1;
    }
    for(int i=r+1;i<n;i++) {
        if(s[i]==s[r]) pos=1;
    }
    if(pos) cout<<"YES\n";
    else cout<<"NO\n";
}
 */
public class nonSubstrSeq {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0)
        {
            int n = scanner.nextInt(), q = scanner.nextInt();
            scanner.nextLine();
            char[] ch = scanner.nextLine().toCharArray();

            int[] l0 = new int[n];
            int[] r0 = new int[n];
            int[] l1 = new int[n];
            int[] r1 = new int[n];

            for(int i = 1; i < n; i++) {
                l0[i] = l0[i - 1] + (ch[i - 1] == '0' ? 1 : 0);
                l1[i] = l1[i - 1] + (ch[i - 1] == '1' ? 1 : 0);
            }
            for(int i = n-2; i >= 0; i--) {
                r0[i] = r0[i + 1] + (ch[i + 1] == '0' ? 1 : 0);
                r1[i] = r1[i + 1] + (ch[i + 1] == '1' ? 1 : 0);
            }

            while (q-- > 0)
            {
                int l = scanner.nextInt()-1, r = scanner.nextInt()-1;
                if(ch[l] == '0' && l0[l] > 0 ||
                        ch[l] == '1' && l1[l] > 0 ||
                        ch[r] == '0' && r0[r] > 0 ||
                        ch[r] == '1' && r1[r] > 0)
                            System.out.println("YES");
                else
                    System.out.println("NO");
            }

        }
    }
}
