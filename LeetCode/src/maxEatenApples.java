import java.util.*;

public class maxApples {
	public static void main(String[] args)
	{
		System.out.print(eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}));
		System.out.print(eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}));
	}
	public static int eatenApples(int[] apples, int[] days) {
		int n = apples.length;
		PriorityQueue<int[]> q = new PriorityQueue<>((i,j) -> i[1]-j[1]);
		for(int i = 0; i < n; i++) q.add(new int[] {apples[i], i+days[i]});

		int day = 0;
		while (!q.isEmpty()) {
			while(!q.isEmpty() && !(q.peek()[0] > 0 && q.peek()[1] > day)) q.remove();
			if(q.isEmpty()) break;

			int[] at = q.remove();
			int toEat = Math.min(at[0], at[1]-day);
			day += toEat;

			at[0] -= toEat;
			if(at[0] > 0) q.add(at);
		}

		return day;
	}
}
