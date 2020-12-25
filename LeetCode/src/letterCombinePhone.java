import java.util.*;

public class combineDigits {
	ArrayList<String> res = new ArrayList<String>();
	String[] map = new String[] {"", "", "abc", "def", "ghi",
			"jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations_v0(String digits) {
		if(digits.length() == 0) return res;

		for(char d : map[digits.charAt(0)-'0'].toCharArray())
			res.add(d+"");

		for(int i = 1; i < digits.length(); i++) {
			ArrayList<String> cur = (ArrayList<String>) res.clone();
			res.clear();
			for(char d : map[digits.charAt(i)-'0'].toCharArray())
				for(int j = cur.size()-1; j >= 0; j--)
					res.add(cur.get(j)+(d+""));
		}

		return res;
	}

	public List<String> letterCombinations(String digits) {
		LinkedList<String> q = new LinkedList<>();
		if(digits.length() == 0) return q;

		q.add("");
		int d = 0;
		while(d < digits.length()) {
			int n = q.size();
			for(int i = 0; i < n; i++) {
				String at = q.remove();
				for(char c : map[digits.charAt(d)-'0'].toCharArray())
					q.add(at+c);
			}
			d++;
		}

		return q;
	}

	public List<String> letterCombinations_v2(String digits) {
		if(digits.length() == 0) return res;
		combine(0, "", digits, map);
		return res;
	}
	private void combine(int at, String cur, String digits, String[] map) {
		if(at == digits.length()) {res.add(cur); return;}

		for(char d : map[digits.charAt(at)-'0'].toCharArray())
			combine(at+1, cur+d, digits, map);
	}
}