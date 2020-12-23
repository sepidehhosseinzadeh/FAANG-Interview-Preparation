import java.util.*;

public class wordSerach {
	int[] d = new int[] {0,1,0,-1,0};
	int n,m;
	public boolean exist(char[][] board, String word_) {
		n = board.length; m = board[0].length;
		char[] word = word_.toCharArray();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(board[i][j] == word[0])
					if(dfs(i,j,1,board,word))
						return true;
		return false;

	}
	// o(N⋅3^L): N is number of cells. L is len of word.
	boolean dfs(int x, int y, int idx, char[][] table,char[] word) {
		if(idx == word.length) return true;

		char tmp = table[x][y];
		table[x][y] = '#';

		for(int i = 0; i < 4; i++) {
			int tox = x+d[i], toy = y+d[i+1];
			if(tox< 0|| toy< 0 || tox >= n || toy >= m) continue;
			if(table[tox][toy] == '#') continue;
			if(table[tox][toy] != word[idx]) continue;

			if(dfs(tox,toy,idx+1,table,word)) return true;
		}

		table[x][y] = tmp;
		return false;
	}
}
