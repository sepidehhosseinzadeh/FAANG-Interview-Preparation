import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            Set<Integer> set = new HashSet<Integer>();

            for (int i = 0; i < n; i++)
                set.add(sc.nextInt());

            int cnt = 0;
            for (int i = 0; i < m; i++)
                if (set.contains(sc.nextInt())) cnt++;

            System.out.println(cnt);
        }
    }
}
