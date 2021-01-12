class Solution {
    // From begining unmatched ')' will be shown by negative cnt
    // From end unmatched '(' with positive cnt. "())()((("
    public String minRemoveToMakeValid(String s) {
        char[] ch = s.toCharArray();
        int cnt = 0;
        for(int i = 0; i < ch.length; i++) {
            cnt += ch[i]=='(' ? 1 : ch[i]==')' ? -1 : 0;
            if(cnt < 0) {ch[i] = '-'; cnt++;}
        }
        
        for(int i = ch.length-1; i >= 0 && cnt > 0; i--)  
            if(ch[i] == '(') {
                ch[i] = '-';
                cnt--;
            }
        s = "";
        for(char c : ch) if(c != '-') s += c;
        return s;
    }
}
