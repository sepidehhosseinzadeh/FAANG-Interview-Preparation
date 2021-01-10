import java.util.*;

public class constructArr {
	public static void main(String[] args)
	{
		System.out.println(constructDistancedSequence(3));
	}
	public static int[] constructDistancedSequence(int n) {
		int m = (n-1)*2+1;
		int[] arr = new int[m];
		boolean[] num = new boolean[n+1];
		for(int i = 0; i < m; i++) {
			int j = n, cnt = 0;
			boolean allTrue = false;
			while(!(!num[j] && i+j < m && arr[i] == 0 && (j == 0 || arr[i+j] == 0))) {
				j--;
				if(cnt > 1) {allTrue = true;break;}
				if(j == 0) {j = n; cnt++;}
			}
			if(allTrue) break;
			num[j] = true;
			arr[i] = j; if(j!=1) arr[i+j] = j;
			System.out.println(i + " " + i+j);
		}

		return arr;
	}
}
