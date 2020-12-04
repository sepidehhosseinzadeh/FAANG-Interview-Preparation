import java.util.*;
public class OpenAllHours
{
    public String verify(int N, String[] openingTime, String[] closingTime)
    {
        boolean[][] vis = new boolean[24][60];
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            String[] op = openingTime[i].split(":");
            int ho = Integer.parseInt(op[0]);
            int mo = Integer.parseInt(op[1]);

            String[] cl = closingTime[i].split(":");
            int hc = Integer.parseInt(cl[0]);
            int mc = Integer.parseInt(cl[1]);

            int h = ho, m = mo;
            while (true) {
                if (!vis[h][m]) {
                    cnt++;
                    vis[h][m] = true;
                }

                m++;
                h = (h + m / 60)%24;
                m = m % 60;

                if (h == hc && m == mc)
                    break;
            }
        }

        return cnt == 24*60 ? "correct" : "incorrect";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new OpenAllHours()).verify(2, new String[] {"04:47","16:47"}, new String[] {"16:47","04:47"}),"correct");
            eq(1,(new OpenAllHours()).verify(3, new String[] {"03:00", "18:30", "08:59"}, new String[] {"09:00", "04:15", "19:01"}),"correct");
            eq(2,(new OpenAllHours()).verify(3, new String[] {"03:47", "03:48", "03:49"}, new String[] {"03:44", "03:45", "03:46"}),"incorrect");
            eq(3,(new OpenAllHours()).verify(1, new String[] {"05:00"}, new String[] {"04:59"}),"incorrect");
            eq(4,(new OpenAllHours()).verify(6, new String[] {"01:08", "12:46", "23:28", "20:30", "19:02", "06:41"}, new String[] {"05:56", "18:53", "02:29", "23:26", "23:57", "08:44"}),"incorrect");
            eq(5,(new OpenAllHours()).verify(7, new String[] {"01:12", "11:23", "12:23", "13:05", "18:26", "08:37", "22:08"}, new String[] {"03:21", "13:04", "22:16", "21:46", "08:19", "10:17", "13:01"}),"correct");
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
