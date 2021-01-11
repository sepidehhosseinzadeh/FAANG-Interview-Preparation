import java.util.*;

public class maxScoreDeleteab {
	public static void main(String[] args)
	{
		System.out.print(maximumGain("aabbaaxybbaabb", 5,4));
		System.out.print(maximumGain("cdbcbbaaabab", 4,5));

	}
	public int maximumGain_v0(String s, int x, int y) {
		return y > x ? score_v0(new StringBuilder(s), 'a', 'b', x, y) :
				score_v0(new StringBuilder(s), 'b', 'a', y, x);
	}
	private int score_v0(StringBuilder s, char a, char b, int x, int y) {
		int res = 0;
		for(int i = 0; i+1 < s.length();) {
			if(s.charAt(i) == b && s.charAt(i+1) == a) {
				res += y;
				s = s.delete(i,i+2);
				i = Math.max(0, i-1);
			} else i++;
		}
		for(int i = 0; i+1 < s.length();) {
			if(s.charAt(i) == a && s.charAt(i+1) == b) {
				res += x;
				s = s.delete(i,i+2);
				i = Math.max(0, i-1);
			} else i++;

		}
		return res;
	}
	StringBuilder s;
	public int maximumGain_v1(String s, int x, int y) {
		this.s = new StringBuilder(s);
		char a = 'a', b = 'b';
		if(x > y) {
			int t=x;x=y;y=t;
			a='b'; b='a';
		}
		return score_v1(a,b,x,y)+score_v1(b,a,y,x);
	}
	private int score_v1(char a, char b, int x, int y) {
		int res = 0;
		for(int i = 0; i+1 < s.length();) {
			if(s.charAt(i) == b && s.charAt(i+1) == a) {
				res += y;
				s = s.delete(i,i+2);
				i = Math.max(0, i-1);
			} else i++;
		}
		return res;
	}

	// stack sol
	public static int maximumGain(String s, int x, int y) {
		return y > x ? score(new StringBuilder(s), 'a', 'b', x, y) :
				score(new StringBuilder(s), 'b', 'a', y, x);
	}
	private static int score(StringBuilder s, char a, char b, int x, int y) {
		int res = 0;
		// why 2 stacks? coz we must not through away chars that not match,
		// later might match
		Stack<Character> st1 = new Stack<>();
		Stack<Character> st2 = new Stack<>();

		for(int i = 0; i < s.length(); i++) {
			if(!st1.isEmpty() && st1.peek() == b && s.charAt(i) == a) {
				res += y;
				st1.pop();
			} else st1.push(s.charAt(i));
		}
		while(!st1.isEmpty()) {
			char cur = st1.pop();
			if(!st2.isEmpty() && st2.peek() == b && cur == a) {
				res += x;
				st2.pop();
			} else st2.push(cur);
		}
		return res;
	}
}