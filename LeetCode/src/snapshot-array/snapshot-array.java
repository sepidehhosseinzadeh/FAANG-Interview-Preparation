class SnapshotArray {
    ArrayList<HashMap<Integer, Integer>> cache;
    HashMap<Integer, Integer> arr;
    int n;
    public SnapshotArray(int n) {
        this.n = n;
        cache = new ArrayList<>();
        arr = new HashMap<>();
    }
    
    public void set(int index, int val) {
        arr.put(index, val);
    }
    
    public int snap() {
        cache.add(new HashMap<Integer, Integer>(arr));
        return cache.size()-1;
    }
    
    public int get(int index, int snap_id) {
        return cache.get(snap_id).getOrDefault(index, 0);
    }
}
​
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
