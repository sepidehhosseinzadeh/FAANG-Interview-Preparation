import java.util.*;

public class partitionStr {
	public List<Integer> partitionLabels_v0(String s) {
		HashMap<Character, Integer> max =
				new HashMap<>();

		char[] ch = s.toCharArray();
		for(int i = 0; i < ch.length; i++)
			if(max.containsKey(ch[i]))
				max.put(ch[i], Math.max(i,max.get(ch[i])));
			else max.put(ch[i], i);

		ArrayList<Integer> res = new ArrayList<>();
		boolean[] vis = new boolean[26];
		for(int i = 0, j = 0; i < ch.length; i++)
			if(!vis[ch[i]-'a']) {
				int m = max.get(ch[i]);
				for(j = i; j <= m; j++) {
					m = Math.max(m, max.get(ch[j]));
					vis[ch[j]-'a'] = true;
				}
				res.add(m-i+1);
				i = j-1;
			}

		return res;
	}
	public List<Integer> partitionLabels(String s) {
		int[] max = new int[26];

		char[] ch = s.toCharArray();
		for(int i = 0; i < ch.length; i++)
			max[ch[i]-'a'] = i;

		ArrayList<Integer> res = new ArrayList<>();
		for(int i = 0, en = 0, st = 0; i < ch.length; i++) {
			en = Math.max(en, max[ch[i]-'a']); // max index of cur cluster
			if(i == en) { // if encounter to cur cluster's max then add
				res.add(en-st+1);
				st = en+1;
			}
		}

		return res;
	}
}