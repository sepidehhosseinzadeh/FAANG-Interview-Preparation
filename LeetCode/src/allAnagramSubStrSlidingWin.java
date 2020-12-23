import java.util.*;

public class allAnagramSubStrSlidingWin {
	public List<Integer> findAnagrams(String ss, String pp) {
		var res = new ArrayList<Integer>();
		int n = ss.length();
		if(n == 0) return res;

		var p = new HashMap<Character, Integer>();
		for(char c : pp.toCharArray()) p.put(c,p.getOrDefault(c, 0)+1);
		var win = new HashMap<Character, Integer>();
		char[] s = ss.toCharArray();

		int i = 0, j = 0, required = pp.length();
		while(j < n) {
			win.put(s[j], win.getOrDefault(s[j],0)+1);
			if(p.containsKey(s[j]) && win.get(s[j]) <= p.get(s[j])) required--;
			j++;

			while(required == 0 && i < j) {
				if(j-i == pp.length()) res.add(i);

				win.put(s[i], win.get(s[i])-1);

				if(p.containsKey(s[i]) && win.get(s[i]) < p.get(s[i])) required++;
				if(win.get(s[i]) == 0) win.remove(s[i]);
				i++;
			}
		}
		return res;
	}
}
