class Logger {
    Map<String, Integer> tm; 
    /** Initialize your data structure here. */
    public Logger() {
        tm = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int t, String msg) {
        boolean p = true;
        if(tm.containsKey(msg)) 
            if(t-tm.get(msg) < 10) p = false;
        if(p) tm.put(msg, t);
        return p;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */