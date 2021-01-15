class Solution {
    public boolean backspaceCompare_v0(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        
        for(char c : S.toCharArray())
            if(c != '#') s.push(c);
            else if(!s.isEmpty()) s.pop();
        
        for(char c : T.toCharArray())
            if(c != '#') t.push(c);
            else if(!t.isEmpty()) t.pop();
        
        while(!s.isEmpty() && !t.isEmpty() && s.peek() == t.peek()) {
            s.pop(); t.pop();
        }
        
        return s.isEmpty() && t.isEmpty();
    }
    
    public boolean backspaceCompare(String S, String T) {
        int n = S.length(), m = T.length();
        char[] s = S.toCharArray(), t = T.toCharArray();
        
        int bs1 = 0, bs2 = 0;
        int i = n-1, j = m-1;
        while(true) {
            while(i >= 0 && (s[i] == '#' || bs1 > 0) || 
                        j >= 0 && (t[j] == '#' || bs2 > 0)) {
                if(i >= 0 && s[i] == '#') {
                    bs1++; i--;
                }
                else if(j >= 0 && t[j] == '#') {
                    bs2++; j--;
                }
                else if(i >= 0 && s[i] != '#' && bs1 > 0) {
                    bs1--; i--;
                }
                else if(j >= 0 && t[j] != '#' && bs2 > 0) {
                    bs2--; j--;
                }
            }
            if(i >= 0 && j >= 0 && s[i] == t[j]) {
                i--; j--;
            }
            else break;
        }
        return i < 0 && j < 0;
    }
}
