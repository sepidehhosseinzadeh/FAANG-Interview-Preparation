import java.util.*;
public class SquareCityWalking 
{
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    int maxGCD;
    int n;
    public int largestGCD(int N, int[] G)
    {
        n = (int) Math.sqrt(G.length);
        maxGCD = 0;
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(G[0]);
        dfs(0,0,G,new boolean[n][n], n, pathList);
        return maxGCD;
    }

    void dfs(int atx, int aty, int[] G, boolean[][] isVisited, int n, ArrayList<Integer> localPathList)
    {
        isVisited[atx][aty] = true;

        if (atx == n-1 && aty == n-1) {

            int curGcd = localPathList.get(0);
            for(int i:localPathList)
                curGcd = gcd(curGcd, i);

            maxGCD = Math.max(maxGCD, curGcd);

            isVisited[n-1][n-1] = false;
            return;
        }

        for(int i = 0; i < 4; i++)
        {
            int tox = atx+dx[i], toy = aty+dy[i];
            if(tox >= 0 && toy >= 0 && tox < n && toy < n)
            if (!isVisited[tox][toy]) {

                localPathList.add(G[tox*n+toy]);
                dfs(tox, toy, G, isVisited, n,localPathList);
                localPathList.remove(localPathList.size()-1);
            }
        }
        isVisited[atx][aty] = false;
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a == b)
            return a;

        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new SquareCityWalking()).largestGCD(3, new int[] { 96, 42, 45,
                 32, 36, 27,
                 40, 54, 84 }),6);
            eq(1,(new SquareCityWalking()).largestGCD(3, new int[] { 4, 9, 2,
                 3, 5, 7,
                 8, 1, 6 }),1);
            eq(2,(new SquareCityWalking()).largestGCD(4, new int[] { 54, 81, 27, 36,
                 48, 64, 96, 72,
                 84, 60, 45, 99,
                 80, 90, 40, 63 }),9);
            eq(3,(new SquareCityWalking()).largestGCD(1, new int[] { 47 }),47);
            eq(4,(new SquareCityWalking()).largestGCD(5, new int[] { 100,  80,  64,  48,  36,
                  75,  10,  10,  10,  48,
                  50,  10,  10,  10,  64,
                  25,  10,  10,  10,  80,
                   5,  25,  50,  75, 100 }),10);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
    private static void eq( int n, int a, int b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, double a, double b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, char a, char b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
    }
    private static void eq( int n, long a, long b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, boolean a, boolean b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, String a, String b ) {
        if ( a != null && a.equals(b) )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
    }
    private static void eq( int n, int[] a, int[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++)
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, long[] a, long[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, String[] a, String[] b ) {
        if ( a.length != b.length) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if( !a[i].equals( b[i])) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void print( int a ) {
        System.err.print(a+" ");
    }
    private static void print( long a ) {
        System.err.print(a+"L ");
    }
    private static void print( String s ) {
        System.err.print("\""+s+"\" ");
    }
    private static void print( int[] rs ) {
        if ( rs == null) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( long[] rs) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( String[] rs ) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print( "\""+rs[i]+"\"" );
            if( i != rs.length-1)
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
