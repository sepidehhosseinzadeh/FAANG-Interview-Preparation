import java.util.*;

public class shortestPalindrome {
	// o(n^2)
	// find the longest palindrome from begining,
	// and append the rest (reversed) at begining.
	public String shortestPalindrome_v0(String s) {
		String rev = new StringBuilder(s).reverse().toString();
		int n = s.length();
		for(int i = 0; i < n; i++)
			if(s.startsWith(rev.substring(i)))
				return rev.substring(0, i)+s;

		return "";
	}

	// find the longest possible palindrom from index 0 to i
	// add the revesed str(i to n) to the begining
	// call recursely 0 to i
	// if i == s.length() means it's palindrome, so return s
	public String shortestPalindrome_v1(String s) {
		int n = s.length(), i = 0, j;
		// this for loop stops at index i
		// stopped index i means the max possible index that
		// contains longest palindrome str
		// so, we recursively deal with 0 to i, and must
		// add i to end (reversed) at begining
		for(j = n-1; j >= 0; j--)
			if(s.charAt(i) == s.charAt(j)) i++;

		// if i == s.length() means it's palindrome, so return s
		if(i == n) return s;

		String suffix = s.substring(i);
		return new StringBuilder(suffix).reverse().toString() +
				shortestPalindrome(s.substring(0,i)) + suffix;
	}

	// KMP o(2*n)
	// txt = s+#+rev : kmp on this. w are interested on finding kmp[n-1] of this txt.
	// meaning that what is the longest suffix at n-1 that also a prefix.
	// notice that prefix is s and suffix is reversed s.
	// so longest suffix on rev that is also a prefix on s at index 0
	// so this len is longest palindrome
	// we need to append the rest on rev at begining.
	public String shortestPalindrome(String s) {
		String rev = new StringBuilder(s).reverse().toString();
		int[] lps = kmp((s+"#"+rev).toCharArray());

		return rev.substring(0, rev.length()-lps[lps.length-1])+s;
	}
	int[] kmp(char[] txt) {
		int[] p = new int[txt.length];
		p[0] = 0;
		for(int i = 1; i < txt.length; i++) {
			int len = p[i-1];
			while(len > 0 && txt[i] != txt[len]) len = p[len-1];
			p[i] = len + (txt[i] == txt[len]?1:0);
		}
		return p;
	}
}
