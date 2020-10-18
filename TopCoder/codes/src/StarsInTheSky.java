import java.util.*;
public class StarsInTheSky
{
    int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
    public int countPictures(int n, int[] x, int[] y)
    {
        int cnt = 0;
        for(int i = 1; i < (1 << n); i++)
        {
            int minX=MAX, minY=MAX, maxX=MIN, maxY=MIN;
            for(int j = 0; j < n; j++)
                if((i & (1<<j)) != 0)
                {
                    minX = Math.min(minX, x[j]);
                    minY = Math.min(minY, y[j]);
                    maxX = Math.max(maxX, x[j]);
                    maxY = Math.max(maxY, y[j]);
                }

            boolean ok = true;
            for(int j = 0; j < n; j++)
                if((i & (1<<j)) == 0 && inside(x[j],y[j],minX,minY,maxX,maxY))
                {
                    ok = false;
                    break;
                }

            if(ok) cnt++;
        }
        return cnt;
    }

    private boolean inside(int x, int y, int minX, int minY, int maxX, int maxY) {
        return minX <= x && x <= maxX && minY <= y && y <= maxY;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new StarsInTheSky()).countPictures(4, new int[] {1, 2, 3, 4}, new int[] {1, 1, 1, 1}),10);
            eq(1,(new StarsInTheSky()).countPictures(4, new int[] {100, 200, 200, 100}, new int[] {100, 100, 200, 200}),9);
            eq(2,(new StarsInTheSky()).countPictures(3, new int[] {10000, 11000, 12000}, new int[] {52000, 50000, 51000}),7);
            eq(3,(new StarsInTheSky()).countPictures(7, new int[] {0, 6, 2, 3, 4, 0, 6}, new int[] {0, 0, 4, 5, 6, 10, 10}),45);
            eq(4,(new StarsInTheSky()).countPictures(15, new int[] {3, 141592653, 589793238, 462643383, 279502884, 197169399, 375105820, 974944592, 307816406, 286208998, 628034825, 342117067, 982148086, 513282306, 647093844}, new int[] {1, 414213562, 373095048, 801688724, 209698078, 569671875, 376948073, 176679737, 990732478, 462107038, 850387534, 327641572, 735013846, 230912297, 24924836}),613);
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
