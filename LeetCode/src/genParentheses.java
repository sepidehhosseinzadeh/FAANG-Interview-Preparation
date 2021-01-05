import java.util.*;

public class genParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		par(0, 0, n, "", res);
		return res;
	}
	void par(int l, int r, int n, String cur, List<String> res) {
		if(r > l) return;
		if(l == r && l == n) {res.add(cur); return;}

		if(l < n)
			par(l+1,r,n, cur+"(", res);
		par(l,r+1,n, cur+")", res);
	}
}
