        return res;    
    }
}
​
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
