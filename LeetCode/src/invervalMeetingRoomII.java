import java.util.*;

public class invervalMeetingRoomII {
	public int minMeetingRooms_v0(int[][] in) {
		if (in.length == 0) return 0;
		Arrays.sort(in, (i, j) -> i[0] - j[0]);
		int[] t = new int[1000000];
		for (int i = 0; i < in.length; i++) {
			t[in[i][0]]++;
			t[in[i][1]]--;
		}

		int cnt = 0, max = 0;
		for (int i : t) {
			cnt += i;
			max = Math.max(cnt, max);
		}

		return max;
	}

	public int minMeetingRooms(int[][] in) {
		int n = in.length;
		if (n == 0) return 0;

		int[] st = new int[n], en = new int[n];
		for (int i = 0; i < in.length; i++) {
			st[i] = in[i][0];
			en[i] = in[i][1];
		}
		Arrays.sort(st);
		Arrays.sort(en);

		int add = 0, max = 0;
		int i = 0, j = 0;
		while (i < n) {
			if (st[i] >= en[j]) {
				j++;
			}
			else {
				add++;
			}
			i++;
			max = Math.max(max, add);
		}

		return max;
	}

	// !!!!
    /*public int minMeetingRooms_v1(Interval[] intervals) {
        Arrays.sort(intervals,(a,b)->(a.start-b.start));
        PriorityQueue<Interval> pq=new PriorityQueue<>((a,b)->(a.end-b.end));
        for(Interval i:intervals){
            if(!pq.isEmpty()&&pq.peek().end<=i.start){
                pq.poll();
            }
            pq.add(i);
        }
        return pq.size();
    }*/
}
