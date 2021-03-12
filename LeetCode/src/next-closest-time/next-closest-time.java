class Solution {
    public String nextClosestTime(String time) {
        int m = Integer.parseInt(time.substring(0,2))*60 + 
            Integer.parseInt(time.substring(3));
        
        var d = new HashSet<Integer>();
        d.add(m/60/10); d.add(m/60%10);
        d.add(m%60/10); d.add(m%60%10);
        
        int res = m, minElap = 24*60;
        for(int h1:d) for(int h2:d) if(h1*10+h2 < 24)
            for(int m1:d) for(int m2:d) if(m1*10+m2 < 60) {
                int now = (h1*10+h2)*60 + m1*10+m2;
                int elapsed = (now - m + 24*60) % (24*60);
                if(elapsed != 0 && elapsed < minElap) {
                    minElap = elapsed;
                    res = now;
                }
            }
        return String.format("%d%d:%d%d", res/60/10, res/60%10, 
                                            res%60/10, res%60%10);
    }
    
    public String nextClosestTime_v0(String time) {
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
