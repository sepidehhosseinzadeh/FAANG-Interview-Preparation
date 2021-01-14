class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder();
        for(char ch : S.toCharArray()) {
            if(ch != '-')
                res.append(Character.toUpperCase(ch));
        }
        for(int i = res.length()-K; i > 0; i-=K)
            res.insert(i, '-');
            
        return res.toString();
    }
}
