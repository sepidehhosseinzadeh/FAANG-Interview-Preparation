import java.util.*;

public class countSpruce {
	public static void main(String[] args)
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
						}
					}



			System.out.println(cnt);
		}

	}
}
