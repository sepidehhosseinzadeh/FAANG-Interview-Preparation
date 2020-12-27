import java.util.*;

public class basicCalcII {
	// Character.isDigit = ch <= '0' & ch >= '9'
	public int calculate(String s) {
		int n = s.length();
		int prevNum = 0, num = 0, sum = 0, op = '+';
		for(int i = 0; i <= n; i++) {
			while(i < n && s.charAt(i) != ' '&& Character.isDigit(s.charAt(i)))
				num = num*10 + s.charAt(i++)-'0';

			if(i == n || !Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') {
				if(op == '*') num = prevNum*num;
				else if(op == '/') num = prevNum/num;
				else if(op == '-') {num *= -1; sum += prevNum;}
				else sum += prevNum;

				prevNum = num;
				if(i < n) {
					op = s.charAt(i); num = 0;
				} else
					sum += prevNum;
			}

		}
		return sum;
	}
}