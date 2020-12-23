import java.util.*;

public class longestSubStAtMostKdistictChar {
	public int lengthOfLongestSubstringKDistinct(String ss, int k) {
		int n = ss.length();
		if(n == 0) return 0;

		var win = new HashMap<Character, Integer>();
		char[] s = ss.toCharArray();

		int i = 0, j = 0, maxLen = 0;
		while(j < n) {
			while(j < n && win.size() <= k) {
				win.put(s[j], win.getOrDefault(s[j],0)+1);
				j++;
				if(win.size() <= k) maxLen = Math.max(j-i, maxLen);
			}

			while(i < j && win.size() > k) {
				win.put(s[i], win.get(s[i])-1);
				if(win.get(s[i]) == 0) win.remove(s[i]);
				i++;
			}
		}
		return maxLen;
	}
}
