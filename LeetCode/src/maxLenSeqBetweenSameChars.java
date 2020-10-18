import java.util.*;

// 5543. Largest Substring Between Two Equal Characters
public class maxLenSeqBetweenSameChars {
    public int maxLengthBetweenEqualCharacters(String ss) {
        char[] s = ss.toCharArray();
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (map.containsKey(s[i])) {
                int[] arr = map.get(s[i]);
                arr[0] = Math.min(arr[0], i);
                arr[1] = Math.max(arr[1], i);
            }
            else {
                int[] index = new int[2];
                index[0] = index[1] = i;
                map.put(s[i], index);
            }
        }

        int d = -1;
        for (char c : map.keySet()) {
            int[] indice = map.get(c);
            d = Math.max(d, indice[1] - indice[0] - 1);
        }
        return d;
    }
}
