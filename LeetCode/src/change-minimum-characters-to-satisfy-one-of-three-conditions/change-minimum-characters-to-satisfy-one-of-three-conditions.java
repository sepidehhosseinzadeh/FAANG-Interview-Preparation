class Solution {
    public int minCharacters_v0(String a1, String b1) {
        int min = a1.length() + b1.length();
        char[] a = a1.toCharArray();
        char[] b = b1.toCharArray();
        return Math.min(cost3(a,b), Math.min(cost1(a,b), cost1(b,a)));
    }
    int cost3(char[] a, char[] b) {
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
    
    public int minCharacters(String a, String b) {
        int[] na = new int[26], nb = new int[26];
        for(char c : a.toCharArray()) na[c-'a']++;
        for(char c : b.toCharArray()) nb[c-'a']++;
        
        int n = a.length(), m = b.length(), min = n+m;
        for(int i = 0; i < 26; i++) {
            min = Math.min(min, n+m-na[i]-nb[i]); // op 3
            
            if(i > 0) {
                na[i] += na[i-1]; 
                nb[i] += nb[i-1];
            }
            if(i < 25) {
                min = Math.min(min, (n-na[i])+nb[i]);
                min = Math.min(min, na[i]+(m-nb[i]));
            }
        }
        return min;
    }
}

