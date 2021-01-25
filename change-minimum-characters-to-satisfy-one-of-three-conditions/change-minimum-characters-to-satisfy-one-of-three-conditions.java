class Solution {
    public int minCharacters(String a1, String b1) {
        int min = a1.length() + b1.length();
        char[] a = a1.toCharArray();
        char[] b = b1.toCharArray();
        return Math.min(cost2(a,b), Math.min(cost1(a,b), cost1(b,a)));
    }
    int cost2(char[] a, char[] b) {
        int[] cnt = new int[26];
        for(char c : a) cnt[c-'a']++;
        for(char c : b) cnt[c-'a']++;
        
        int max = 0; 
        for(int i = 0; i < 26; i++)
            max = Math.max(max, cnt[i]);
        
        return a.length+b.length-max;
    }
    int cost1(char[] a, char[] b) {
        int min = a.length+b.length;
        for(int i = 1; i < 26; i++) {
            int cost = 0;
            for(int j = 0; j < a.length; j++)
                cost += a[j]-'a' >= i ? 1 : 0;
            for(int j = 0; j < b.length; j++)
                cost += b[j]-'a' < i ? 1 : 0;
            
            min = Math.min(min, cost);
        }
        
        return min;
    }
}
