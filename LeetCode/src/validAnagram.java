import java.util.*;

public class validAnagram {
	public boolean isAnagram(String s, String t) {
		int[] cnt = new int[26];
		for (char c : s.toCharArray()) cnt[c-'a']++;
		for (char c : t.toCharArray()) cnt[c-'a']--;
		for (int i : cnt) if (i != 0) return false;
		return true;
	}
}