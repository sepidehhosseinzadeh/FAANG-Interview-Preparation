import java.util.*;

public class waysBooleanEvalution {
    public static void main(String[] a)
    {
        System.out.println(waysEval("0&0&0&1^1|0", 1));
    }
    static int waysEval(String cur, int target)
    {
        if(cur.isEmpty())
            return 0;
        if(cur.length() == 1)
            if(cur.charAt(0) == '0' || cur.charAt(0) == '1')
                return Integer.parseInt(cur);

        int ways = 0;
        for(int i = 0; i < cur.length(); i++)
            if(cur.charAt(i) == '|' || cur.charAt(i) == '&' || cur.charAt(i) == '^')
            {
                int eval1T = waysEval(cur.substring(0, i), 1);
                int eval2T = waysEval(cur.substring(i+1), 1);
                int eval1F = waysEval(cur.substring(0, i), 0);
                int eval2F = waysEval(cur.substring(i+1), 0);

                int subways = 0;
                switch (cur.charAt(i))
                {
                    case '|':
                        subways += eval1T*eval2T + eval1F*eval2T +eval1T*eval2F;
                        break;
                    case '^':
                        subways += eval1F*eval2T +eval1T*eval2F;
                        break;
                    case '&':
                        subways += eval1T*eval2T;
                        break;
                }
                ways += subways;
            }

        return ways;
    }
}
