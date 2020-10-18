import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- >0)
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            boolean can = true;

            if(n+m > a+b || Math.min(a,b) < m) {
                System.out.println("No");
                continue;
            }

            System.out.println();
        }

    }
}
