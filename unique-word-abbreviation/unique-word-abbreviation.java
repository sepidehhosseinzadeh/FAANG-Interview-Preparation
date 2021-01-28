class ValidWordAbbr {
    Map<String, HashSet<String>> abb2w;
    Map<String, String> w2abb;
    public ValidWordAbbr(String[] dic) {
        abb2w = new HashMap<>();
        w2abb = new HashMap<>();
        for(String w : dic) {
            String abb = abb(w);
            w2abb.put(w,abb);
            HashSet<String> ws = abb2w.getOrDefault(abb, new HashSet<>());
            ws.add(w);
            abb2w.put(abb, ws);
        }
    }
    private String abb(String w) {
        String abb = w;
        if(w.length() > 2) 
            abb = w.charAt(0)+""+(w.length()-2)+""+w.charAt(w.length()-1);
        return abb;
    }
    public boolean isUnique(String w) {
        String abb = abb(w);
        if(!abb2w.containsKey(abb)) return true;
        if(w2abb.containsKey(w) && abb2w.get(abb).size()==1)
            return true;
        return false;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */