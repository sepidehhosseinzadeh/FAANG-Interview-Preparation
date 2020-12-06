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
			max = Math.max(cnt, max); // we need to find the most overlapped intervals
		}

		return max;
	}
	public int minMeetingRooms_v1(int[][] intervals) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int[] itl : intervals) {
			map.put(itl[0], map.getOrDefault(itl[0], 0) + 1);
			map.put(itl[1], map.getOrDefault(itl[1], 0) - 1);
		}
		int room = 0, k = 0;
		for (int v : map.values())
			k = Math.max(k, room += v);

		return k;
	}

	public int minMeetingRooms_v2(int[][] in) {
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
			//max = Math.max(max, add); no need for max!!
		}

		return add;
	}
	public int minMeetingRooms_v3(int[][] in) {
		int n = in.length;
		int[] starts = new int[n];
		int[] ends = new int[n];
		for(int i=0; i<n; i++) {
			starts[i] = in[i][0];
			ends[i] = in[i][1];
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endsItr = 0;
		for(int i=0; i<starts.length; i++) {
			if(starts[i]<ends[endsItr])
				rooms++;
			else
				endsItr++;
		}
		return rooms;
	}

	// heap
	public int minMeetingRooms(int[][] in) {
		Arrays.sort(in, (i, j) -> i[0] - j[0]); // sort based on start. I see the meetings based on start time, and add room
		var q = new PriorityQueue<int[]>((i, j) -> i[1] - j[1]); // q is based on end. I remove meetings from q based on end time!

		for (int i = 0; i < in.length; i++) {
			if (!q.isEmpty() && q.peek()[1] <= in[i][0])
				q.poll();
			q.offer(in[i]);
		}

		return q.size();
	}
}