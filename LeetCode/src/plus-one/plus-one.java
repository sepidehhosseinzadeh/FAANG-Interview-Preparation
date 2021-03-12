class Solution {
    public int[] plusOne(int[] d) {
        int n = d.length;
        int s = (d[n-1]+1)%10, carry = (d[n-1]+1)/10;
        d[n-1] = s;
        for(int i = n-2; i >= 0; i--) {
            s = (d[i]+carry)%10;
            carry = (d[i]+carry)/10;
            d[i] = s;
        }
        if(carry == 1) {
            int[] ret = new int[n+1];
            for(int i = 0; i < n; i++) ret[i+1] = d[i];
            ret[0] = 1;
            return ret;
        } 
        return d;
    }
}