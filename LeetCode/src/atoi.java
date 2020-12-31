import java.util.*;

public class atoi {
	public int myAtoi(String s) {
		int i = 0, n = s.length();
		// first non space
		while(i < n && s.charAt(i) == ' ') i++;

		if(i == n || (s.charAt(i) != '-' &&
				s.charAt(i) != '+' &&
				!Character.isDigit(s.charAt(i)))) return 0;

		String sign = "";
		if(s.charAt(i) == '-') sign = s.charAt(i++)+"";
		else if(s.charAt(i) == '+') i++;

		if(i == n || !Character.isDigit(s.charAt(i))) return 0;

		String num = "";
		while(i < n && Character.isDigit(s.charAt(i))) {
			num += s.charAt(i++);
			if(Long.parseLong(num) > Integer.MAX_VALUE)
				return sign.equals("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		return Integer.parseInt(sign+""+num);
	}
}