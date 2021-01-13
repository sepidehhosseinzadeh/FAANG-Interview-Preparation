class Solution {
    
    public int lengthLongestPath(String input) { 
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
