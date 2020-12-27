import java.util.*;

public class maxEatenApples {
	public int eatenApples(int[] apples, int[] days) {
		int n = apples.length;
		PriorityQueue<int[]> q = new PriorityQueue<>((i,j) -> i[1]-j[1]);

		// THIS IS FUU**WRONG!!!! ON THE DAY IT GROWS APPLES!!!!
		// APPLES ADD TP Q ON THE DAY!!!!
		/*for(int i = 0; i < n; i++) q.add(new int[] {apples[i], i+days[i]});*/

		int eaten = 0;
		for(int day = 0; day < n || !q.isEmpty(); day++) {
			if(day < n) q.add(new int[] {apples[day], day+days[day]});
			while(!q.isEmpty() && !(q.peek()[0] > 0 && q.peek()[1] > day)) q.poll();

			if(!q.isEmpty()) {
				int[] at = q.poll();
				eaten++;
				at[0]--;
				q.add(at);
			}
		}

		return eaten;
	}
}
