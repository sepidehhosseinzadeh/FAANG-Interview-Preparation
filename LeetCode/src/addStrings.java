import java.util.*;

public class addStrings {
	public String addStrings_v0(String num1, String num2) {
		int n = num1.length(), m = num2.length();
		if(n > m) return addStrings(num2,num1);

		int i = n-1, j = m-1;
		int carry = 0;
		String res = "";
		while(i >= 0) {
			int sum = num1.charAt(i)-'0' + num2.charAt(j)-'0'+carry;
			carry = sum/10;
			sum %= 10;
			res = sum+res;
			i--; j--;
		}

		while(j >= 0) {
			int sum = num2.charAt(j)-'0'+carry;
			carry = sum/10;
			sum %= 10;
			res = sum+res;
			j--;
		}
		if(carry > 0) res = carry + res;

		return res;
	}

	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			sb.append((x + y + carry) % 10);
			carry = (x + y + carry) / 10;
		}
		return sb.reverse().toString();
	}
}