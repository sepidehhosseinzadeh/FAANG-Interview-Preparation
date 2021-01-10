import java.util.*;

public class maxScoreDelab {
	public static void main(String[] args)
	{
		System.out.print(maximumGain("aabbaaxybbaabb", 5,4));
		System.out.print(maximumGain("cdbcbbaaabab", 4,5));

	}
	public static int maximumGain(String s, int x, int y) {
		return y > x ? score(new StringBuilder(s), 'a', 'b', x, y) :
				score(new StringBuilder(s), 'b', 'a', y, x);
	}
	private static int score(StringBuilder s, char a, char b, int x, int y) {
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
}
