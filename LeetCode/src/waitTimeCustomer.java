import java.util.*;

public class tst {
	public static void main(String[] args)
	{
		System.out.print(averageWaitingTime(new int[][] {{2,3},{6,3},{7,5},{11,3},{15,2},{18,1}}));
	}
	public static double averageWaitingTime(int[][] c) {
		int n = c.length;

		double w = 0;
		int t = 0;
		for(int i = 0; i < n; i++) {
			int wait = (Math.max(0, t-c[i][0])+c[i][1]);
			w += wait;
			t = c[i][0]+wait;
		}
		return w/n;
	}
}
