import java.util.*;

public class basicCalcII {
	// Character.isDigit = ch <= '0' & ch >= '9'
	public int calculate_v0(String s) {
		int n = s.length();
		int prevNum = 0, num = 0, sum = 0, op = '+';
		for(int i = 0; i <= n; i++) {
			while(i < n && Character.isDigit(s.charAt(i)))
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

	public int calculate_v1(String s) {
		int n = s.length();
		Stack<Integer> nums = new Stack<>(); // ..+...+...+..

		int num = 0, op = '+';
		for(int i = 0; i <= n; i++) {
			while(i < n && Character.isDigit(s.charAt(i)))
				num = num*10 + s.charAt(i++)-'0';

			if(i == n || !Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') {
				if(op == '*') nums.push(nums.pop()*num);
				else if(op == '/') nums.push(nums.pop()/num);
				else if(op == '-') nums.push(-num);
				else nums.push(num);

				if(i < n) {
					op = s.charAt(i); num = 0;
				}
			}
		}
		int sum = 0;
		while(!nums.isEmpty()) sum += nums.pop();
		return sum;
	}

	public int calculate(String s) {
		int sum = 0;
		int tempSum = 0;
		int num = 0;
		char lastSign = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) num = num * 10 + c - '0';
			if (i == s.length() - 1 || !Character.isDigit(c) && c!=' ') {
				switch(lastSign) {
					case '+':
						sum+=tempSum;
						tempSum = num;
						break;
					case '-':
						sum+=tempSum;
						tempSum = -num;
						break;
					case '*':
						tempSum *= num;
						break;
					case '/':
						tempSum /= num;
						break;
				}
				lastSign = c;
				num=0;
			}
		}
		sum+=tempSum;
		return sum;
	}
}