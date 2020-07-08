class isInterLeavedStr{
    //C is said to be interleaving A and B, if it contains all characters of A and B and
    // order of all characters in individual strings is preserved.
    public boolean isInterLeave(String a,String b,String c)
    {
        int n = a.length(), m = b.length(), l = c.length();
        if(n + m != l)
            return false;

        boolean [][] isIL = new boolean[n+1][m+1];
        isIL[0][0] = true;

        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= m; j++)
            {
                if(i+j<=l && i>0 && c.charAt(i+j-1) == a.charAt(i-1))
                    isIL[i][j] |= isIL[i-1][j];
                if(i+j<=l && j>0 && c.charAt(i+j-1) == b.charAt(j-1))
                    isIL[i][j] |= isIL[i][j-1];
            }

        return isIL[n][m];

    }
    public static boolean isInterleavedRecursive(
            char str1[], char str2[], char str3[],
            int pos1, int pos2, int pos3){
        if(pos1 == str1.length && pos2 == str2.length &&
                pos3 == str3.length){
            return true;
        }

        if(pos3 == str3.length){
            return false;
        }

        return (pos1 < str1.length && str1[pos1] == str3[pos3] &&
                isInterleavedRecursive(str1, str2, str3, pos1+1, pos2, pos3+1))
                || (pos2 < str2.length && str2[pos2] == str3[pos3] &&
                isInterleavedRecursive(str1, str2, str3, pos1, pos2+1, pos3+1));

    }
}