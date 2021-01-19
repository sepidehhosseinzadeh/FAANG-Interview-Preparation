class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int minMove = Integer.MAX_VALUE;
        for(int v = 1; v < 7; v++) {
            int n = Switch(0, v, new int[][]{A, B});
            int m = Switch(1, v, new int[][]{A, B});
            minMove = Math.min(minMove, Math.min(n,m));
        }
        
        return minMove == Integer.MAX_VALUE ? -1: minMove;
    }
    int Switch(int r, int v, int[][] M) {
        int move = 0;
        for(int i = 0; i < M[0].length; i++) {
            if(M[r][i] == v) continue;
            else if(M[1-r][i] == v) move++;
            else return Integer.MAX_VALUE;
        }
        
        return move;
    }
}
