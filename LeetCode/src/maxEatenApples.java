import java.util.*;

public class maxEatenApples {
	public int eatenApples_v0(int[] apples, int[] days) {
		int n = apples.length;
		// priority based on expiry date, use sooner the about to expire ones
		PriorityQueue<int[]> q = new PriorityQueue<>((i,j) -> i[1]-j[1]);

		// THIS IS FUU** WRONG!!!! ON THE DAY IT GROWS APPLES!!!!
		// APPLES ADD TP Q ON THE DAY!!!!
		/*for(int i = 0; i < n; i++) q.add(new int[] {apples[i], i+days[i]});*/

		int eaten = 0;
		for(int day = 0; day < n || !q.isEmpty(); day++) {
			if(day < n) q.add(new int[] {apples[day], day+days[day]});
			while(!q.isEmpty() && !(q.peek()[0] > 0 && q.peek()[1] > day)) q.poll();

			if(!q.isEmpty()) {
				int[] at = q.poll();
				eaten++; at[0]--;
				if(at[0] > 0) q.add(at);
			}
		}

		return eaten;
	}


	public int eatenApples(int[] apples, int[] days) {
		int n = apples.length;
		int[] exp = new int[(int) 2e4+n];
		int lastDay = n; // this increase when we have more unspoiled apples
		int minExp = exp.length;
		int eaten = 0;
		for(int day = 0; day < lastDay; day++) {
			int curExp = 0;
			if(day < n) {
				curExp = day+days[day];
				exp[curExp] += apples[day]; // grown apples

				lastDay = Math.max(lastDay, curExp);
				// we better eat apples w/ min exp date first
				minExp = Math.min(minExp, curExp);
			}

			// rm spoiled ones
			// **** no apple || expired -> move
			// *** IF YOU HAVE 2 while for each,
			// will not gaurantee to point to
			// a valid day!!!!
			while(minExp < lastDay &&
					(exp[minExp] == 0 || day >= minExp))
				minExp++;

			if(exp[minExp] > 0) {
				eaten++;
				exp[minExp]--;
			}
		}
		return eaten;
	}
}