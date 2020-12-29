import java.util.*;

public class ticTacToe {
	public class TicTacToe {
		int n;
		boolean won;
		int[][] r;
		int[][] c;
		int[][] d;
		/** Initialize your data structure here. */
		public TicTacToe(int n) {
			this.n = n;
			won = false;
			r = new int[2][n];
			c = new int[2][n];
			d = new int[2][2];
		}

		/** Player {player} makes a move at ({row}, {col}).
		 @param row The row of the board.
		 @param col The column of the board.
		 @param player The player, can be either 1 or 2.
		 @return The current winning condition, can be either:
		 0: No one wins.
		 1: Player 1 wins.
		 2: Player 2 wins. */
		public int move(int row, int col, int player) {
			if(won) return 0;
			player--;
			r[player][row]++;
			c[player][col]++;
			if(row==col) d[player][0]++;
			if(row+col == n-1) d[player][1]++;
			if(r[player][row] == n || c[player][col] == n ||
					d[player][0] == n || d[player][1] == n)  {
				won = true;
				return player+1;
			}
			return 0;
		}
	}

	class TicTacToe_ {
		private int[] rows;
		private int[] cols;
		private int diagonal;
		private int antiDiagonal;

		public TicTacToe_(int n) {
			rows = new int[n];
			cols = new int[n];
		}
		public int move(int row, int col, int player) {
			int n = rows.length;
			int toAdd = player == 1 ? 1 : -1;

			rows[row] += toAdd;
			cols[col] += toAdd;
			if (row == col) diagonal += toAdd;
			if (col == n-row-1) antiDiagonal += toAdd;


			if (Math.abs(rows[row]) == n ||
					Math.abs(cols[col]) == n ||
					Math.abs(diagonal) == n  ||
					Math.abs(antiDiagonal) == n) return player;

			return 0;
		}
	}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}