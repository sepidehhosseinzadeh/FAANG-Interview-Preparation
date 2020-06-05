import java.util.*;

public class nQueen {
    ArrayList<ArrayList<String>> res;
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        res = new ArrayList<ArrayList<String>>();
        char[][] table = new char[n][n];
        for(char[] a: table)
            Arrays.fill(a, '.');

        nqueen(0, n, table);

        return res;
    }
    public boolean nqueen(int at, int n, char[][] table)
    {
        if(at >= n)
        {
            ArrayList<String> tmp = new ArrayList<String>();
            for(int i = 0; i < n; i++)
            {   String cc = "";
                for(int j = 0; j < n; j++)
                    cc += table[i][j];
                tmp.add(cc);
            }
            res.add(tmp);
            return true;
        }
        for(int i = 0; i < n; i++)
            if(safe(i, at, n, table))
            {
                table[i][at] = 'Q';
                nqueen(at+1, n, table);
                table[i][at] = '.';
            }

        return false;
    }
    boolean safe(int x, int y, int n, char[][] table)
    {
        for(int i = 0; i < n; i++)
            if(table[i][y] == 'Q')
                return false;
        for(int i = 0; i < n; i++)
            if(table[x][i] == 'Q')
                return false;
        for(int j = 0; j < n; j++)
            if(inBound(x+y-j, n) && table[x+y-j][j] == 'Q' ||
                    inBound(x-y+j, n) && table[x-y+j][j] == 'Q')
                return false;
        return true;
    }
    boolean inBound(int x, int n)
    {
        return x >= 0 && x < n;
    }

}
