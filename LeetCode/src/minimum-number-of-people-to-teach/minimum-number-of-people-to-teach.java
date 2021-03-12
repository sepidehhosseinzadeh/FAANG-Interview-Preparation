class Solution {
    public int minimumTeachings(int n, int[][] la, int[][] f) {
        int m = la.length;
        HashSet<Integer>[] lan = new HashSet[m+1];
        for (int i = 1; i <= m; i++) lan[i] = new HashSet<>();
        for (int i = 1; i <= m; i++) 
            for (int j : la[i-1]) lan[i].add(j);
        
        ArrayList<Integer>[] neigh = new ArrayList[m+1];
        for (int i = 1; i <= m; i++) neigh[i] = new ArrayList<>();
        
        for (int[] i : f) {
            boolean speak = false;
            for (int l : lan[i[0]])
                if (lan[i[1]].contains(l)) {
                    speak = true;
                    break;
                }
            if (speak) continue;
            
            if(!neigh[i[0]].contains(i[1])) neigh[i[0]].add(i[1]);
            if(!neigh[i[1]].contains(i[0])) neigh[i[1]].add(i[0]);
        }
​
        int res = m;
        for(int l = 1; l <= n; l++) {
            int need = 0;
            for(int j = 1; j <= m; j++)
                if(neigh[j].size() > 0)
                    if(!lan[j].contains(l)) need++;
            res = Math.min(res, need);
        }
​
        return res;
    }
}
