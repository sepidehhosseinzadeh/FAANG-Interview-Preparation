import java.util.*;

public class maxLenConcatUniqChar {
	public int maxLength_v0(List<String> list) {
		int n = list.size();
		int maxLen = 0;

		for(int i = 0, len; i <= 1<<n; i++)
			if((len=canJoin(i, list)) != -1)
				maxLen = Math.max(maxLen, len);

		return maxLen;
	}
	int canJoin(int state, List<String> list) {
		boolean[] ch = new boolean[26];
		int len = 0;
		for(int i = 0; i < list.size(); i++)
			if((state & (1 << i)) != 0)
				if(noOverLap(ch, list.get(i)))
					len += list.get(i).length();
				else return -1;
		return len;
	}
	boolean noOverLap(boolean[] ch, String str) {
		for(char c : str.toCharArray())
			if(ch[c-'a']) return false;
			else ch[c-'a'] = true;
		return true;
	}

	public int maxLength(List<String> list) {
		int n = list.size(), maxLen = 0;
		var dp = new ArrayList<Integer>(); // bitsets of
		//diff combinations of strs
		dp.add(0); // no str
		for(String s : list) {
			// check if there is dup inside s
			int sbit = 0, dup = 0;
			for(char c : s.toCharArray()) {
				if((sbit & (1 << (c-'a'))) != 0) dup = 1;
				sbit |= (1 << (c-'a'));
				if(dup > 0) break;
			}
			if(dup > 0) continue;
			// create a combiation of s and all prev strs if possible
			// start from end to prevent checking newly added ones
			for(int i = dp.size()-1; i >= 0; i--) {
				int combit = dp.get(i);
				if((combit & sbit) == 0) {
					dp.add(combit | sbit);
					maxLen = Math.max(maxLen, Integer.bitCount(combit | sbit));
				}
			}
		}
		return maxLen;
	}

	private int result = 0;

	public int maxLength_v2(List<String> arr) {
		if (arr == null || arr.size() == 0) return 0;
		dfs(arr, "", 0);
		return result;
	}

	private void dfs(List<String> arr, String path, int idx) {
		boolean isUniqueChar = isUniqueChars(path);

		if (isUniqueChar) result = Math.max(path.length(), result);
		if (idx == arr.size() || !isUniqueChar) return;

		for (int i = idx; i < arr.size(); i++)
			dfs(arr, path + arr.get(i), i + 1);// each time, look ahead!!!
	}

	private boolean isUniqueChars(String s) {
		Set<Character> set = new HashSet<>();

		for (char c : s.toCharArray()) {
			if (set.contains(c)) return false;
			set.add(c);
		}
		return true;
	}
}