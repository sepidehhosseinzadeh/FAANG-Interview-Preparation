import java.util.*;

public class countSpruce {
	// TLE
	public static void main_(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			scanner.nextLine();
			char[][] mat = new char[n][m];
			for(int i = 0; i < n; i++)
				mat[i] = scanner.nextLine().toCharArray();

			int cnt = 0;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					if(mat[i][j] == '*') {
						cnt++;
						for(int r = 1; i+r < n; r++) {

							boolean ok = true;
							for (int c = -r; c <= r; c++)
								if (!(i+r < n && j+c >= 0 && j+c < m &&
										mat[i + r][j + c] == '*')) {
									ok = false;
									break;
								}

							if(ok) cnt++;
							else break;
						}
					}



			System.out.println(cnt);
		}

	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			scanner.nextLine();
			char[][] mat = new char[n][m];
			int[][] dp = new int[n][m];

			for(int i = 0; i < n; i++)
				mat[i] = scanner.nextLine().toCharArray();

			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					if(mat[i][j] == '*') {
						dp[i][j] = 1;
						if (j > 0) dp[i][j] += dp[i][j - 1];
					}
			int cnt = 0;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					if(mat[i][j] == '*') {
						cnt++;
						for (int k = 2; k <= 500; k++)
							if(i + k - 1 < n && j + k - 1 < m){
								if (j - k + 1 == 0) {
									if (dp[i + k - 1][j + k - 1] == 2 * k - 1) cnt++;
									else break;
								} else if (j - k + 1 - 1 >= 0)
									if (dp[i + k - 1][j + k - 1] - dp[i + k - 1][j - k + 1 - 1] == 2 * k - 1) cnt++;
									else break;
							}

					}

			System.out.println(cnt);
		}

	}
}
