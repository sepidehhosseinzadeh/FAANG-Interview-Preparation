import java.util.*;
// https://codeforces.com/contest/1451/problem/A
/*if(x==1) cout<<0<<'\n';
else if(x==2) cout<<1<<'\n';
else if(x%2==0||x==3) cout<<2<<'\n';
else cout<<3<<'\n';
*/
public class nTo1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0)
        {
            long n = scanner.nextLong();

            Queue<Long> q = new LinkedList<Long>();
            q.add(n);
            q.add((long)0);

            while(!q.isEmpty())
            {
                long at = q.poll();
                long d = q.poll();

                if(at == 1) {System.out.println(d); break;}

                long bd = div(at);
                if(bd != -1) {q.add(at/bd); q.add(d+1);}
                q.add(at-1); q.add(d+1);
            }
        }
    }
    static long div(long n)
    {
        if(n == 2) return -1;
        for(int i = 2; i*i <= n; i++)
            if(n%i == 0)   return Math.max(i, n/i);
        return -1;
    }
}
