import java.util.*;

public class generateParenthesis
{
    static ArrayList<String> res;
    public static void main(String[] args)
    {
        res = new ArrayList<>();

        generateParenthesis("", 6, 0,0);
        for(String str: res)
            System.out.println(str);

    }
    public static boolean generateParenthesis(String at, int n, int l, int r)
    {
        if(l < r || n < 0)
            return false;

        if(n == 0 && l==r)
            res.add(at);

        generateParenthesis("("+at, n-1, l+1, r);
        generateParenthesis(at+")", n-1, l, r+1);

        return true;

    }
}
