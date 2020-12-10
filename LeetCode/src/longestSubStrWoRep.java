import java.util.*;

public class longestSubStrWoRep {
	// o(n^2)
	public int lengthOfLongestSubstring_v0(String s) {
		char[] ch = s.toCharArray();
		var set = new HashSet<Character>();
		int maxLen = 0;

		int i = 0, j = 0, n = ch.length;
		while(j < n) {
			while(j < n && !set.contains(ch[j])) {
				set.add(ch[j++]);
				maxLen = Math.max(maxLen, set.size());
			}
			while(i < n && j < n && ch[i] != ch[j]) {
				set.remove(ch[i++]);
			}
			i++; j++; //i removed, j is added ch[i]==ch[j]
		}
		return maxLen;
	}

	// o(n)
	public int lengthOfLongestSubstring_v1(String s) {
		char[] ch = s.toCharArray();
		var set = new HashSet<Character>();
		int maxLen = 0;
		int n = ch.length;

		for(int i = 0, j = 0; j < n;) {
			if(!set.contains(ch[j])) { // not in set! great! add it!
				set.add(ch[j++]);
				maxLen = Math.max(maxLen, set.size());
			} else  // remove until we can add j
				set.remove(ch[i++]);
		}
		return maxLen;
	}

	// o(n)
	public int lengthOfLongestSubstring(String s) {
		char[] ch = s.toCharArray();
		var map = new HashMap<Character, Integer>();
		int maxLen = 0;
		int n = ch.length;

		for(int i = 0, j = 0; j < n; j++) {
			if(map.containsKey(ch[j]))
				i = Math.max(i, map.get(ch[j])+1); // last index of not repeat ch[j]

			maxLen = Math.max(maxLen, j-i+1);
			map.put(ch[j], j);
		}
		return maxLen;
	}
}