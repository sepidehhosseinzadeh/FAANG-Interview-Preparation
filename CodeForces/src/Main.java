import java.util.*;

public class maxPalinK {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt(), k = scanner.nextInt();

			char[] res = new char[n];
			for(int i = 0; i < k; i++) {
				res[i] = 'a';
			}
			for(int i = k, j = 1; i < n; i++, j = (j+1)%3)
				res[i] = (char)(j+'a');
			System.out.println(new String(res));
		}

	}
}
