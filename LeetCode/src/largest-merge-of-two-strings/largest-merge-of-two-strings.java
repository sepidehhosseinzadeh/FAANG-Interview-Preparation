class Solution {
    public String largestMerge(String w1, String w2) {
        int n = w1.length(), m = w2.length();
        StringBuilder res = new StringBuilder();

        int i = 0, j = 0;
        while(i < n || j < m) {
            if(i < n && j < m) {
                if(w1.substring(i).compareTo(w2.substring(j)) > 0) 
                    res.append(w1.charAt(i++));
                else 
                    res.append(w2.charAt(j++));
            } 
            else if(i < n) 
                res.append(w1.charAt(i++));
            else if(j < m) 
                res.append(w2.charAt(j++));
        }
        return res.toString();
    }
}