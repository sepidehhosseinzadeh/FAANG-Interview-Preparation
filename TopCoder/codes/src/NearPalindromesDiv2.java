public class NearPalindromesDiv2
{
    public String solve(String S)
    {
        int n = S.length();
        char[] s = S.toCharArray();
        boolean[] odd = new boolean[26];

        for(char c : s) odd[c-'a'] = !odd[c-'a'];

        for(int c = 0; c < 26; c++)
            if(odd[c])
                for(int i = 0; i < n; i++)
                    if(s[i]-'a' != c && odd[s[i]-'a'])
                    {
                        odd[s[i]-'a'] = false;
                        odd[c] = false;

                        s[i] = (char)(c+'a');
                        break;
                    }
        String res = "";
        for(char c : s) res += c;
        return res;

    }
}
