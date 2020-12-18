import java.util.*;

class wordSearchII {
	class Solution_ { // 217 ms
		class TrieNode {
			TrieNode[] child;
			boolean isEnd;
			TrieNode() {
				child = new TrieNode[26];
				isEnd = false;
			}
			public void insert(String w) {
				TrieNode at = this;
				for(int i = 0; i < w.length(); i++) {
					if(at.child[w.charAt(i)-'a'] == null)
						at.child[w.charAt(i)-'a'] = new TrieNode();
					at = at.child[w.charAt(i)-'a'];
				}
				at.isEnd = true;
			}
		}
		int[] d = new int[]{0,1,0,-1,0};
		public List<String> findWords(char[][] board, String[] words) {
			int n = board.length, m = board[0].length;
			var res = new ArrayList<String>();

			TrieNode t = new TrieNode();
			for(String w : words) t.insert(w);

			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					if(t.child[board[i][j]-'a'] != null)
						dfs(i, j, board, t.child[board[i][j]-'a'], board[i][j]+"", res);

			return res;
		}
		void dfs(int ax, int ay, char[][] table, TrieNode t, String cur, ArrayList<String> res) {
			if(t.isEnd) {
				res.add(cur); t.isEnd = false; // de-duplicate
			}

			char tmp = table[ax][ay];
			table[ax][ay] = '#';

			for(int i = 0; i < 4; i++) {
				int tx = ax+d[i], ty = ay+d[i+1];
				if(tx < 0 || ty < 0 ||
						tx >= table.length || ty >= table[0].length ||
						table[tx][ty] == '#' || t.child[table[tx][ty]-'a'] == null)
					continue;

				dfs(tx,ty,table,t.child[table[tx][ty]-'a'], cur+table[tx][ty],res);
			}

			table[ax][ay] = tmp;
		}
	}

	/*********************************************************/
	class Solution { // 1 ms!!! hashmap, pruning
		class TrieNode {
			HashMap<Character,TrieNode> child;
			String word;
			TrieNode() {
				child = new HashMap<Character,TrieNode>();
				word = "";
			}
			public void insert(String w) {
				TrieNode at = this;
				for(int i = 0; i < w.length(); i++) {
					if(!at.child.containsKey(w.charAt(i)))
						at.child.put(w.charAt(i), new TrieNode());
					at = at.child.get(w.charAt(i));
				}
				at.word = w;
			}
		}
		int[] d = new int[]{0,1,0,-1,0};

		public List<String> findWords(char[][] board, String[] words) {
			int n = board.length, m = board[0].length;
			var res = new ArrayList<String>();

			TrieNode t = new TrieNode();
			for(String w : words) t.insert(w);

			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					if(t.child.containsKey(board[i][j]))
						dfs(i,j,board,t,res);

			return res;
		}
		void dfs(int ax, int ay, char[][] table, TrieNode par,ArrayList<String> res) {
			TrieNode t = par.child.get(table[ax][ay]); // this is for pruning the tree at end

			if(!t.word.equals("")) {
				res.add(t.word); t.word = ""; // de-duplicate
			}

			char tmp = table[ax][ay];
			table[ax][ay] = '#';

			for(int i = 0; i < 4; i++) {
				int tx = ax+d[i], ty = ay+d[i+1];
				if(tx < 0 || ty < 0 ||
						tx >= table.length || ty >= table[0].length ||
						table[tx][ty] == '#' || !t.child.containsKey(table[tx][ty]))
					continue;

				dfs(tx,ty,table,t,res);
			}

			table[ax][ay] = tmp;

			if(par.child.get(table[ax][ay]).child.isEmpty())
				par.child.remove(table[ax][ay]);
		}
	}
}
