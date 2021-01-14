class Solution {
    public int totalFruit(int[] tree) {
        int maxn = 0;
        var cnt = new HashMap<Integer, Integer>();
        for(int i = 0, j = 0; j < tree.length; j++) {
            cnt.put(tree[j], cnt.getOrDefault(tree[j],0)+1);
            while(cnt.size() > 2) {
                cnt.put(tree[i], cnt.get(tree[i])-1);
                cnt.remove(tree[i++], 0);
            }
            maxn = Math.max(maxn, j-i+1);
        }
        return maxn;
    }
    public int totalFruit_v1(int[] tree) {
        var cnt = new HashMap<Integer, Integer>();
        int i=0, j;
        for(j = 0; j < tree.length; j++) {
            cnt.put(tree[j], cnt.getOrDefault(tree[j],0)+1);
            if(cnt.size() > 2) {
                cnt.put(tree[i], cnt.get(tree[i])-1);
                cnt.remove(tree[i++], 0);
            }
        }
        return j-i;
    }
}
