import java.util.*;

public class shortestPalindrome {
	// o(n^2)
	public String shortestPalindrome_v0(String s) {
		String rev = new StringBuilder(s).reverse().toString();
		int n = s.length();
		for(int i = 0; i < n; i++)
			if(s.startsWith(rev.substring(i)))
				return rev.substring(0, i)+s;

		return "";
	}
	// o(n) w/ KMP
}
