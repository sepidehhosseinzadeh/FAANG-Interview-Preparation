import java.util.*;

public class removeKdigits {
	// we need to delete a digit that is in the left and
	// is bigger than its right. 114 when we need to delete 4
	// that 11 are deleted then it has a effect on num. So
	// no worries on right digits, we need to go from left to right
	// when we see a digit (stack's top) that
	// is bigger than it's right (cur digit) delete the digit (pop());
	// we need a monotonic increasing sequence in stack!
	public String removeKdigits(String num, int k) {
		int n = num.length();
		char[] d = num.toCharArray();
		Stack<Character> s = new Stack<>();

		for(int i = 0; i < n; i++) {
			while(!s.isEmpty() && k > 0 && s.peek() > d[i]) {
				s.pop();
				k--;
			}
			s.push(d[i]);
		}
		while(!s.isEmpty() && k > 0) {
			s.pop();
			k--;
		}

		StringBuilder res = new StringBuilder("");
		for(char c : s) {
			if(res.length()==0 && c=='0') continue;
			res.append(c);
		}

		return res.length() == 0 ? "0" : res.toString();
	}

	// TLE brute force
	public String removeKdigits_v0(String num, int k) {
		int n = num.length();
		char[] digits = num.toCharArray();

		int min = Integer.parseInt(num);
		for(int i = 1<<n; i >= 0; i--)
			if(Integer.bitCount(i) <= k) {
				char[] d = digits.clone();
				for(int j = 0; j < n; j++)
					if((1<<j & i) != 0)
						d[j] = '#';
				String newNum = "";
				for(char c : d)
					if(c != '#') newNum += c;
				if(newNum.length() == 0) newNum = "0";
				min = Math.min(Integer.parseInt(newNum), min);
			}

		return min+"";
	}
}