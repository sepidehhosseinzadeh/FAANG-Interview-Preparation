import java.util.*;

public class canChangeTonext {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt(), k = scanner.nextInt();
            scanner.nextLine();
            String aa = scanner.nextLine(), bb = scanner.nextLine();
            char[] a = aa.toCharArray();
            char[] b = bb.toCharArray();

            if(n == k && !aa.equals(bb)) {
                System.out.println("No"); continue;
            }

            int[] na = new int[26];
            int[] nb = new int[26];

            for(char c : a) na[c-'a']++;
            for(char c : b) nb[c-'a']++;

            int remain = 0;
            boolean No = false;
            for(int i = 0; i < 26; i++)
            {
                na[i] += remain; remain = 0;
                if(nb[i] > na[i]) {
                    No = true; break;
                }
                if(na[i] > 0) na[i] -= nb[i];
                remain += na[i];
            }
            System.out.println((No || remain > 0) ? "No" : "Yes");
        }
    }
}
