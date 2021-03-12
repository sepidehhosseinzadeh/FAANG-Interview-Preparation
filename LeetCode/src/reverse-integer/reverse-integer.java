class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int last = x%10;
            int nres = res * 10 + last;
            if((nres-last)/10 != res) return 0; // overflow
            res = nres;
            x /= 10;
        }
        return res;
    }
}
