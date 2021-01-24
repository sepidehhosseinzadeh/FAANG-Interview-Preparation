class Solution {
    public String maximumTime(String time) {
        int h = (time.charAt(0)!='?' ? (time.charAt(0)-'0')*10 : (time.charAt(1)=='?' ? 20 : (time.charAt(1)-'0'>=4 ? 10 : 20))) + 
            (time.charAt(1)!='?' ? time.charAt(1)-'0': (time.charAt(0)-'0' < 2 ? 9 : 3));
        int m = (time.charAt(3)!='?' ? (time.charAt(3)-'0')*10 : 50) + 
            (time.charAt(4)!='?' ? time.charAt(4)-'0' : 9);
        return (h<10 ? "0"+h : h) +":"+ (m<10 ? "0"+m : m);
    }
}
