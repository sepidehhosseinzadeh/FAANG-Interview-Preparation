import java.util.*;

public class excelToColAndVS {
	public String convertToTitle(int n) {
		int base = 26;
		StringBuilder num = new StringBuilder();
		while(n > 0) {
			n--;     // need to adjust every time to map n to corresponding char
			num.insert(0,(char)(n%base+'A'));
			n /= base;
		}
		return num.toString();
	}
	public String convertToTitle_v1(int n) {
		return n==0 ? "" : convertToTitle((--n)/26) + (char)(n%26+'A');
	}

	// VS
	public int titleToNumber(String s) {
		return s.equals("") ? 0 : s.charAt(s.length()-1)-'A'+1 +
				26*titleToNumber(s.substring(0,s.length()-1));
	}
}
