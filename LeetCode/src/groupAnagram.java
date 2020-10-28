import java.util.*;

public class groupAnagram {
    public static void main(String[] args)
    {
        System.out.print(groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> groups = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            int[] cnt = new int[26];
            for(char c : strs[i].toCharArray())
                cnt[c-'a']++;

            StringBuilder s = new StringBuilder("");
            for(int j = 0; j < 26; j++)
                while(cnt[j]-- > 0)
                    s.append((char)(j+'a'));

            ArrayList<String> group = map.getOrDefault(s.toString(), new ArrayList<String>());
            group.add(strs[i]);
            map.put(s.toString(), group);
        }

        for(ArrayList<String> s : map.values())   groups.add(s);

        return groups;

    }
    public List<List<String>> groupAnagrams_v1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11 ,13, 17, 19, 23,
                                                29, 31, 37, 41, 43, 47, 53, 59, 61,
                                                67, 71, 73, 79, 83, 89, 97, 101, 107};
    public List<String> anagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            int hash = 1;
            for (char c : strs[i].toCharArray()) hash *= PRIMES[c-'a'];

            List<String> group = map.getOrDefault(hash, new LinkedList<>());
            group.add(strs[i]);
            map.put(hash, group);
        }

        List<String> res = new LinkedList<>();
        for (List<String> mapList:map.values()) res.addAll(mapList);

        return res;
    }
    public List<List<String>> groupAnagrams_v2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

}
