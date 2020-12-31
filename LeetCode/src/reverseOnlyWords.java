import java.util.*;

public class reverseOnlyWords {
	public void reverseWords_v0(char[] s) {
		reverse(s, 0, s.length-1);
		// reverse words
		for(int i = 0, j; i < s.length; i++) {
			if(s[i] != ' ') {
				for(j = i+1; j < s.length && s[j] != ' '; j++);
				reverse(s, i, j-1);
				i = j;
			}
		}

	}

	public void reverseWords(char[] s) {
		reverse(s, 0, s.length-1);
		// reverse words
		for(int j = 0, i = 0; j <= s.length; j++) {
			if(j == s.length || s[j] == ' ') {
				reverse(s, i, j-1);
				i = j+1;
			}
		}
	}

	void reverse(char[] s, int i, int j) {
		while(i < j) {
			char t = s[i]; s[i] = s[j]; s[j] = t;
			i++; j--;
		}
	}
}