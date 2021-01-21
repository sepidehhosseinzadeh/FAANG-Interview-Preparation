class Solution {
    Map<String, Map<String, Double>> G;
    public double[] calcEquation(List<List<String>> rel, double[] val, List<List<String>> q) {
        G = new HashMap<>();
        for(int i = 0; i < rel.size(); i++) { 
            String a = rel.get(i).get(0), b = rel.get(i).get(1);
            Map<String, Double> ato = G.getOrDefault(a, new HashMap<>());
            Map<String, Double> bto = G.getOrDefault(b, new HashMap<>());
            ato.put(b, val[i]);
            bto.put(a, 1.0/val[i]);
            G.put(a, ato); G.put(b, bto);
        }
        
        double[] res = new double[q.size()];
        Arrays.fill(res, -1);
        for(int i = 0; i < q.size(); i++) {
            String a = q.get(i).get(0), b = q.get(i).get(1);
            if(!G.containsKey(a) || !G.containsKey(b)) continue;
            
            HashSet<String> vis = new HashSet<>();
            //vis.add(a);
            res[i] = dfs("", a, b, 1, vis);    
        }
        
        return res;    
    }
    double dfs(String p, String at, String end, double mult, HashSet<String> vis) {
        if(at.equals(end)) return mult;
        
        for(String to : G.get(at).keySet()) {
            if(to.equals(p) || vis.contains(to)) continue;
            vis.add(to);
            double ret = dfs(at, to, end, mult*G.get(at).get(to), vis);
            if(ret != -1.0) return ret;
        }
        
        return -1.0;
    }
}
