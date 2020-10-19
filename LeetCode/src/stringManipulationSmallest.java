import java.util.*;

// 1625. Lexicographically Smallest String After Applying Operations
public class stringManipulationSmallest {
    public String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> vis = new TreeSet<>();
        int[] arr = new int[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) arr[i++] = Integer.parseInt(c + "");

        dfs(arr, vis, a, b);

        String res = "";
        String[] f = vis.first().split("[\\[ ,\\]]");
        for (String c : f) res += c;
        return res;
    }

    void dfs(int[] at, TreeSet<String> vis, int a, int b)
    {
        if (vis.contains(Arrays.toString(at))) return;

        vis.add(Arrays.toString(at));

        int[] tmp = at.clone(), tmp1 = at.clone();
        for (int i = 1; i < at.length; i += 2)
            tmp[i] = (tmp[i] + a) % 10;

        // s.substring(len) + s.substring(0, len)
        for (int i = 0; i < at.length; i++)
            tmp1[(i + b) % at.length] = at[i];

        dfs(tmp, vis, a, b);
        dfs(tmp1, vis, a, b);
    }
}