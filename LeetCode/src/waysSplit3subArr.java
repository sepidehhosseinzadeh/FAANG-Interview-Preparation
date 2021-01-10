import java.util.*;

public class waysSplit3subArr {
	int mod = (int)(1e9+7);

	// o(n^2) TLE
	public int waysToSplit_v0(int[] nums) {
		int n = nums.length;
		int[] sum = new int[n+1];
		for(int i = 1; i <= n; i++)
			sum[i] = sum[i-1]+nums[i-1];

		long cnt = 0;
		for(int i = 1; i <= n-2; i++) { // end of left (not included)
			for(int j = i+1; j <= n-1; j++) { // end of mid, not included, start of right, included
				int left = sum[i];
				int mid = sum[j]-sum[i];
				int right = sum[n]-sum[j];
				if(left <= mid && mid <= right) cnt++;
				cnt %= mod;
			}
		}

		return (int) cnt;
	}

	// linear search on end of left, and
	// bineary search on mid's left side and right side.
	public int waysToSplit_v1(int[] nums) {
		int n = nums.length;
		int[] sum = new int[n+1];
		for(int i = 1; i <= n; i++)
			sum[i] = sum[i-1]+nums[i-1];

		long cnt = 0;
		for(int i = 0; i < n; i++) {
			int left = sum[i+1];
			int lb = binarySearch(sum, left, i+1, n, true);
			int ub = binarySearch(sum, left, i+1, n, false);
			if(lb < 0 || ub < 0) continue;
			cnt = (cnt+(ub-lb+1)%mod)%mod;
		}

		return (int) cnt;
	}

	int binarySearch(int[] sum, int left, int st, int n, boolean isLb) {
		int lb = st, ub = n-2, res = -1;
		while(lb <= ub) {
			int m = lb+(ub-lb)/2;
			int mid = sum[m+1]-left, right = sum[n]-mid-left;
			if(left <= mid && mid <= right) {
				res = m;
				if(isLb) ub = m-1;
				else lb = m+1;
			}
			else if(left > mid) lb = m+1;
			else ub = m-1;
		}
		return res;
	}

	// TLE!!!!
	public int waysToSplit_WRONG(int[] nums) {
		int n = nums.length;
		for(int i = 1; i < n; i++) nums[i] += nums[i-1];

		int cnt = 0;
		for(int i=0; i < n-2; i++) {
			int j=i+1;
			while(j < n-1 && nums[i] > nums[j]-nums[i]) // every time starts from i+1, not continues where it left off
				j++;
			int k = j;
			while(k < n-1 && nums[k]-nums[i] <= nums[n-1]-nums[k]) // same reason!!
				k++;
			cnt = (cnt+k-j)%mod;
		}
		return cnt%mod;
	}

	public int waysToSplit(int[] nums) {
		int n = nums.length;
		for(int i = 1; i < n; i++) nums[i] += nums[i-1];

		int cnt = 0;
		for(int i=0, j=i+1, k=j; i < n-2; i++) {
			while(j <= i || (j < n-1 && nums[i] > nums[j]-nums[i])) j++;
			while(k < j || (k < n-1 && nums[k]-nums[i] <= nums[n-1]-nums[k])) k++;
			cnt = (cnt+k-j)%mod;
		}
		return cnt;
	}
}
