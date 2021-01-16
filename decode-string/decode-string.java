class Solution {
    public String decodeString(String S) {
        Stack<String> stack = new Stack<>();
        
        char[] s = S.toCharArray();
        for(int i = 0, n = s.length; i < n; ) {
            if(s[i] == '[') 
                i++;
            else if(Character.isDigit(s[i])) {
                String num = S.substring(i, S.indexOf("[", i));
                stack.push(num); i += num.length();
            }
            else if(s[i] == ']' && !stack.isEmpty()) {
                String str = stack.pop();
                String num = stack.pop();
                while(!Character.isDigit(num.charAt(0))) {
                    num = num+str;
                    str = num;
                    num = stack.pop();
                }
                String ret = "";
                for(int j = 0; j < Integer.valueOf(num); j++) 
                        ret += str;
                while(!stack.isEmpty() && 
                        Character.isLetter(stack.peek().charAt(0)))
                    ret = stack.pop()+ ret;
                
                stack.push(ret);
                i++;
            } 
            else {
                String str = "";
                while(i < n && Character.isLetter(s[i])) str += s[i++];   
                stack.push(str);
            }
        }
        
        String res = "";
        while(!stack.isEmpty()) res = stack.pop()+res;
        return res;    
    }
}
