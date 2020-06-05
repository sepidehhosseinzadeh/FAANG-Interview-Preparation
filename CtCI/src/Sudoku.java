public class Sudoku {
    static int count;
    public static void main(String[] a)
    {
        count = 0;
        //solveSudoku();
    }
    boolean solveSudoku(int[][] board, int n, int atx, int aty)
    {
        if(atx == n)
        {
            count++;
            return true;
        }

        // try all the numbers in this cell
        for(int num = 1; num <= n; num++)
        {
            if(isSafe(board, atx, aty, num, n))
            {
                board[atx][aty] = num;
                if(solveSudoku(board, n, atx+(aty+1)/n,
                                    (aty+1)%n))
                    return true;
                board[atx][aty] = 0;
            }
        }
        return false;

    }
    boolean isSafe(int[][] sudoku, int i, int j, int x, int n)
    {
        for (int jj = 0; jj < n; jj++) {
            if (sudoku[i][jj] == x) {
                return false;
            }
        }

        for (int ii = 0; ii < n; ii++) {
            if (sudoku[ii][j] == x) {
                return false;
            }
        }

        int boxRow = i - i % 3;
        int boxColumn = j - j % 3;

        for (int ii = 0; ii < 3; ii++) {
            for (int jj = 0; jj < 3; jj++) {
                if (sudoku[boxRow + ii][boxColumn + jj] == x) {
                    return false;
                }
            }
        }
        return true;
    }

}
