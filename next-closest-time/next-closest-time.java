class Solution {
    public String nextClosestTime(String time) {
        int m = Integer.parseInt(time.substring(0,2))*60 + 
            Integer.parseInt(time.substring(3));
        
        var set = new HashSet<Integer>();
        set.add(m/60/10); set.add(m/60%10);
        set.add(m%60/10); set.add(m%60%10);
        
        do {
            m = (m+1) % (24*60);
        } while(!allowed(m, set));
        
        return String.format("%d%d:%d%d", m/60/10, m/60%10, 
                                m%60/10, m%60%10);
    }
    boolean allowed(int m, HashSet<Integer> d) {
        int d1 = m/60/10, d2 = m/60%10; 
        int d3 = m%60/10, d4 = m%60%10;
        return d.contains(d1) && d.contains(d2) && 
            d.contains(d3) && d.contains(d4);
    }
}
