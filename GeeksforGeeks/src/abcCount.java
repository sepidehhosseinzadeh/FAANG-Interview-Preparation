import java.util.*;
import java.lang.*;

/*
Given a string s, count number of subsequences of the form aibjck,
where i >= 1, j >=1 and k >= 1.
Note: Two subsequences are considered different if the set of array indexes
picked for the 2 subsequences are different.
 */
class abcCount {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0)
        {
            String s = sc.nextLine();
            System.out.println(count(s.toCharArray()));
        }
    }
    static int count(char[] s)
    {
        int aN=0, bN=0, cN=0;
        // aN: #of aa..a ended this a.
        // bN: #of aa...abb...b ended this b.
        // cN: #of aa...abb...bcc...c ended this c.
        for(char c : s)
            if(c == 'a')
                aN = 1+aN+aN;
                // itself only + all n a before + all n a before and itself.
            else if(c == 'b')
                bN = aN+bN+bN;
                // aN: a...aab
                // bN: a...aab...bb (past bs)
                // bN: a...aab...bb b (past bs + current b)
            else if(c == 'c')
                cN = bN+cN+cN;

        return cN;
    }
}