class Solution {
    public String getHint(String secret, String guess) {
        int[] cnt = new int[10];
        boolean[] match = new boolean[guess.length()];
        int bull = 0, cow = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++; match[i] = true;
            }
            else cnt[secret.charAt(i)-'0']++;
        }
        for(int i = 0; i < guess.length(); i++) 
            if(!match[i] && cnt[guess.charAt(i)-'0'] > 0) {
                cnt[guess.charAt(i)-'0']--;
                cow++;
            }
        return bull+"A"+cow+"B";
    }
}