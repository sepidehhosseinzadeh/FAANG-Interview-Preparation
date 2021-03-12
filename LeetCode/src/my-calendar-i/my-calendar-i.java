class MyCalendar {
    ArrayList<int[]> cal;
    public MyCalendar() {
        cal = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int i;
        for(i = 0; i < cal.size(); i++) 
            if(cal.get(i)[0] <= start && start < cal.get(i)[1] ||
                cal.get(i)[0] < end && end < cal.get(i)[1] || 
                cal.get(i)[0] > start && cal.get(i)[0] < end) return false;
            else if(start >= cal.get(i)[1]) break;
        cal.add(i, new int[]{start, end});
        return true;
    }
}
​
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
