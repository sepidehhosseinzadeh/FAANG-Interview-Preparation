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
        if(cur.length() == 1) // base case is 1 digit
            if(cur.charAt(0) == '0' || cur.charAt(0) == '1')
                return Integer.parseInt(cur) == target ? 1 : 0; // 1 way or 0 ways

        int ways = 0;
        for(int i = 1; i < cur.length(); i+=2)
            if(cur.charAt(i) == '|' || cur.charAt(i) == '&' || cur.charAt(i) == '^')
            {
                int eval1T = waysEval(cur.substring(0, i), 1);
                int eval2T = waysEval(cur.substring(i+1), 1);
                int eval1F = waysEval(cur.substring(0, i), 0);
                int eval2F = waysEval(cur.substring(i+1), 0);

                int totalWays = (eval1F+eval1T)*(eval2F+eval2T);

                int subwaysTrue = 0;
                switch (cur.charAt(i))
                {
                    case '|':
                        subwaysTrue += eval1T*eval2T + eval1F*eval2T +eval1T*eval2F;
                        break;
                    case '^':
                        subwaysTrue += eval1F*eval2T +eval1T*eval2F;
                        break;
                    case '&':
                        subwaysTrue += eval1T*eval2T;
                        break;
                }

                ways += target == 1 ? subwaysTrue : totalWays-subwaysTrue;
            }

        return ways;
    }
}
