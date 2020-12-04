import java.util.*;
public class FakeReportData
{
    /*
    The first digits of all our integers must be distinct.
    The last digits of all our integers must be distinct.
    Within each integer the digits must be distinct.
     */
    public int[] generate(int N, int D)
    {
        boolean[][][] num = new boolean[N][D][10];
        boolean[][] within = new boolean[N][10];
        int[] res = new int[N];

        for(int i = 0; i < D; i++) {
            int len = 0;
            for (int j = 0; j < N; j++)
                for (int k = 0; k < 10; k++) {
                    if (!num[j][i][k] && within[j][k]) {
                        num[j][i][k] = within[j][k] = true;
                        res[j] = res[j] * 10 + k;
                        len++;
                        break;
                    }
                }
            if(len != i+1) {

            }
        }

        return res;

    }
    int[] num;
    boolean find(int at, int digit, int N, int D, int[] cur) {
        if(at == N-1 && digit == D) {
            num = cur.clone();
            return true;
        }
        for(int i = (digit==0?1:0); i < 10; i++)
            if(can(cur, at, digit)) {
                int prev = cur[at];
                cur[at] = cur[at]*10+digit;
                if(find((at+1)%N, digit+(at+1)/N, N,D,cur)) return true;
                cur[at] = prev;
            }
        return false;
    }
    boolean can(int[] nums, int idx, int digit) {
        int[] tmp = nums.clone();
        tmp[idx] = tmp[idx]*10+digit;

        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> last = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            int cur = (int) (nums[i] / Math.pow(10, (nums[i] + "").length() - 1));
            if(first.contains(cur)) return false;
            first.add(cur);
        }
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i] % 10;
            if(last.contains(cur)) return false;
            last.add(cur);
        }

        for(int i = 0; i < nums.length; i++) {
            HashSet<Integer> within = new HashSet<>();
            for (int d = 0; d < (nums[i] + "").length(); d++) {
                int cur = Integer.parseInt((nums[i]+"").charAt(d)+"");
                if(within.contains(cur)) return false;
                within.add(cur);
            }
        }
        return true;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new FakeReportData()).generate(3, 5),new int[] {12947, 31094, 41093 });
            eq(1,(new FakeReportData()).generate(5, 3),new int[] {710, 471, 329, 105, 987 });
            eq(2,(new FakeReportData()).generate(7, 1),new int[] {3, 1, 4, 5, 9, 2, 6 });
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
