class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        if(n > m) return addStrings(num2,num1);
        
        int i = n-1, j = m-1;
        int carry = 0;
        String res = "";
        while(i >= 0) {
            int sum = num1.charAt(i)-'0' + num2.charAt(j)-'0'+carry;
            carry = sum/10;
            sum %= 10;
            res = sum+res;
            i--; j--;
        }
        
        while(j >= 0) {
            int sum = num2.charAt(j)-'0'+carry;
            carry = sum/10;
            sum %= 10;
            res = sum+res;
            j--;
        }
        if(carry > 0) res = carry + res;
        
        return res;
    }
}
