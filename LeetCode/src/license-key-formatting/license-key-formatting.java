class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder(S.replaceAll("-","").toUpperCase());
        for(int i = res.length()-K; i > 0; i-=K)
            res.insert(i, '-');
            
        return res.toString();
    }
}
