import java.util.*;

public class makeBiggestBinary {
	// **We don't need touch the starting 1s, they are already good.
	// 1- we continuely take operation 2, making the string
	// like 00...00011...11
	// 2- we continuely take operation 1, making the string
	// like 11...11011...11.
	public String maximumBinaryString(String b) {
		int n = b.length(), one = 0, zero = 0;
		StringBuilder res = new StringBuilder("1".repeat(n));

		for(int i = 0; i < n; i++)
			if(b.charAt(i) == '0') zero++;
			else if(zero == 0) one++;

		if(one < n) res.setCharAt(one+zero-1, '0');

		return res.toString();
	}
}
