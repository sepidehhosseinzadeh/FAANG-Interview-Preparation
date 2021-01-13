class Solution {
    public int lengthLongestPath_v0(String input) { 
        int maxL = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(String line : input.split("\n")) {
            int t = line.lastIndexOf("\t")+1;
            while(t+1 < stack.size()) stack.pop(); // parent should be at top (#t is # dir before)
            int len = stack.peek()+line.length()-t+1; // 1 for '/'
            stack.push(len);
            if(line.contains(".")) maxL = Math.max(len-1, maxL); // -1 when it's file, no '/' at end
        }
        return maxL;
    }
    
    public int lengthLongestPath(String input) {
        int maxL = 0;
        int[] stack = new int[input.length()+1];
        
        for(String line : input.split("\n")) {
            int t = line.lastIndexOf("\t")+1;
            // parent should be at top (#t is # dir before)
            int len = stack[t]+line.length()-t+1; // 1 for '/'
            stack[t+1] = len;
            if(line.contains(".")) maxL = Math.max(len-1, maxL); // -1 when it's file, no '/' at end
        }
        return maxL;
    }

    
    // separate root dirs, as the following is for 1 root dir
    public int lengthLongestPath_WRONG(String input) { 
        int len = input.length();
        if(len == 0) return 0;
        
        char[] in = input.toCharArray();
    
        // \t is the key to diffrentiate to child
        Map<Integer, ArrayList<int[]>> map = new HashMap<>(); // \t->sub
        
        int t = 0;
        for(int i = 0; i < len; ) {
            if(in[i] == '\n') {i++; t=0;}
            else if(in[i] == '\t') {t++; i++;}
            else {
                int isFile = 0;
                int st = i;
                while(i < len && in[i] != '\n') {
                    if(in[i] == '.') isFile = 1;
                    i++;  
                } 
                
                ArrayList<int[]> sub = 
                            map.getOrDefault(t, new ArrayList<>());
                sub.add(new int[]{i-st, isFile});
                map.put(t, sub);
            }    
        }
        
        if(!map.containsKey(0)) return 0;
        
        int maxL = 0;
        Queue<int[]> q = new LinkedList<>(); // #t, len of path from root to there 
        for(int i = 0; i < map.get(0).size(); i++)
            q.add(new int[]{0, map.get(0).get(i)[0], map.get(0).get(i)[1]});
        
        while(!q.isEmpty()) {
            int[] at = q.poll();
            t = at[0]; int dis = at[1], isFile = at[2];
            if(isFile == 1) maxL = Math.max(maxL, t+dis); // t times '/'
            
            if(!map.containsKey(t+1)) continue;
            
            int nChild = map.get(t+1).size();
            for(int i = 0; i < nChild; i++) 
                q.add(new int[] {t+1, dis+map.get(t+1).get(i)[0], map.get(t+1).get(i)[1]}); 
        }
        
        return maxL;
    }
}
