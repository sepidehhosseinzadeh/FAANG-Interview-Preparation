import java.util.*;

public class constructArr {
	public int[] constructDistancedSequence(int n) {
		int[] arr = new int[2*(n-1)+1];
		boolean[] nums = new boolean[n+1];
		put(0, n, arr, nums);
		return arr;
	}
	// fill each position with max potential num
	boolean put(int at, int n, int[] arr, boolean[] nums) {
		int m = arr.length;
		if(at == m) return true;
		if(arr[at] != 0) return put(at+1,n,arr, nums); // coz we fill at and at+i, so skip if filled

		for(int i = n; i > 0; i--) {
			if(nums[i]) continue;
			if(i > 1 && (at+i >= m || arr[at+i] != 0)) continue;

			nums[i] = true;
			arr[at] = i;
			if(i > 1) arr[at+i] = i;

			if(put(at+1,n, arr, nums)) return true; // return first solution

			nums[i] = false;
			arr[at] = 0;
			if(i > 1) arr[at+i] = 0;
		}
		return false;
	}
}
