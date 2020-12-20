import java.util.*;

public class palindromePermutation {
	public boolean canPermutePalindrome_v0(String s) {
		var odd = new HashMap<Character, Boolean>();
		for(int i = 0; i < s.length(); i++)
			odd.put(s.charAt(i), !odd.getOrDefault(s.charAt(i),false));

		int cnt = 0;
		for(char c : odd.keySet())
			cnt += odd.get(c) ? 1:0;
		return cnt <= 1;
	}
	public boolean canPermutePalindrome_v1(String s) {
		var set=new HashSet<Character>();
		for(int i=0; i<s.length(); ++i)
			if (!set.contains(s.charAt(i))) set.add(s.charAt(i));
			else set.remove(s.charAt(i));

		return set.size() <= 1;
	}
	public boolean canPermutePalindrome(String s) {
		boolean[] odd = new boolean[128];
		for(int c: s.toCharArray()) odd[c] = !odd[c];

		int nOdd = 0;
		for (int i = 0; i < 128 && nOdd <= 1; i++)
			nOdd += odd[i] ? 1 : 0;

		return nOdd <= 1;
	}
}
