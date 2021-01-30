class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i[] : points) {
            HashSet<Integer> y = map.getOrDefault(i[0], new HashSet<>());
            y.add(i[1]);
            map.put(i[0], y);
        }
        
        int area = Integer.MAX_VALUE; 
        for(int i = 0; i < points.length; i++)
            for(int j = i+1; j < points.length; j++) {
                int x0 = points[i][0], y0 = points[i][1];
                int x1 = points[j][0], y1 = points[j][1];
                if(map.containsKey(x0) && map.get(x0).contains(y1) &&
                        map.containsKey(x1) && map.get(x1).contains(y0) && 
                        Math.abs(y1-y0)*Math.abs(x1-x0) > 0)
                    area = Math.min(area, Math.abs(y1-y0)*Math.abs(x1-x0));
            }
        return area == Integer.MAX_VALUE ? 0 : area;
    }
}