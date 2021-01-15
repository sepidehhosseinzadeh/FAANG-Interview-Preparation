class Solution {
    public boolean backspaceCompare(String S, String T) {
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
}
