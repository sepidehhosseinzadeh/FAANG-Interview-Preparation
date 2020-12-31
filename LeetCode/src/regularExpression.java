import java.util.*;

public class regularExpression {
	public boolean isMatch(String s_, String p_) {
		char[] s = s_.toCharArray();
		char[] p = p_.toCharArray();
		int n = p.length, m = s.length;

		boolean[][] matched = new boolean[n+1][m+1]; // p till i, s till j is matched
		matched[0][0] = true;

		for(int i = 1; i <= n; i++) // p
			for(int j = 0; j <= m; j++) { // s
				if(p[i-1] == '*') {
					matched[i][j] = matched[i-2][j]; // match 0 char
					if(j>0 && (p[i-2]==s[j-1] || p[i-2]=='.')) // match more
						matched[i][j] |= matched[i][j-1];
				} else if(j>0 && (p[i-1]==s[j-1] || p[i-1]=='.'))
					matched[i][j] = matched[i-1][j-1];
				else matched[i][j] = false;
			}

		return matched[n][m];
	}
}