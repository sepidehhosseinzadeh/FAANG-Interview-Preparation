class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((i,j) -> j-i);
        q.add(a); q.add(b); q.add(c);
        int r = 0;
        while(q.size() > 1) {
            int o1 = q.poll();
            int o2 = q.poll();
            r++;
            if(o1 > 1) q.add(o1-1);
            if(o2 > 1) q.add(o2-1);
        }
        return r;
    }
}