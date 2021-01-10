import java.util.*;

public class battleshipCount {
	public int countBattleships(char[][] board) {
		int n = board.length, m = board[0].length;
		int cnt = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				if(board[i][j] == 'X')
					if((i == 0 || board[i-1][j] == '.') &&
							(j == 0 || board[i][j-1] == '.')) cnt++;
			}

		return cnt;
	}
}
