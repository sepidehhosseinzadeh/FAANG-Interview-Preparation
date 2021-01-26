class Solution {
    // o(n*m) 
    public int wordsTyping_v0(String[] s, int n, int m) {
        int i = 0, j = 0, k = 0, l = s.length;
        while(i < n) {
            if(m-j-s[k%l].length() >= 0) {
                j += s[k%l].length(); j++; // space
                k++;  
            } 
            else {i++; j = 0;}
        }
        return k/l;
    }
    
    public int wordsTyping(String[] w, int n, int m) {
        String s = String.join(" ", w) + " ";
        int j = 0, l = s.length();
        for(int i = 0; i < n; i++) {
            j += m;
            if(s.charAt(j%l) == ' ') j++;
            while(j > 0 && s.charAt((j-1)%l) != ' ') j--;
        }
        return j/l;
    }
}
