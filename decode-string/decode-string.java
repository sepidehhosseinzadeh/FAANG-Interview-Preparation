class Solution_v0 {
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

class Solution {
    public String decodeString(String S) {
        Stack<String> strs = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        
        char[] s = S.toCharArray();
        int n = s.length;
        
        String curStr = "";
        int curNum = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == '['){
                nums.add(curNum); curNum = 0;
                strs.add(curStr); curStr = "";
            }
            else if(s[i] == ']') {
                String decodedStr = strs.pop();
                int num = nums.pop();
                for(int j = 0; j < num; j++) decodedStr += curStr;
                curStr = decodedStr;
            }
            else if(Character.isDigit(s[i])) 
                curNum = 10*curNum + s[i]-'0';
            else 
                curStr += s[i];
        }
        
        return curStr;    
    }
}
