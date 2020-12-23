import java.util.*;

public class findMissingAndRepeat_findDuplicate {
	public int findDuplicate_v0(int[] nums) {
		int n = nums.length, i = 0;
		while(nums[i] > 0) {
			int to = nums[i];
			nums[i] = -1;
			i = to;
		}
		return i;
	}

	public int findDuplicate_v1(int[] nums) {
		int slow = 0, fast = 0;
		while(slow == 0 || slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		slow = 0;
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

	// o(n)+o(logn): if count of lb to mid are mid+1 then all are unique,
	// then search the other half
	public int findDuplicate(int[] nums) {
		int n = nums.length;
		int[] cnt = new int[n];
		var set = new HashSet<Integer>();
		for(int i = 0; i < n; set.add(nums[i]),cnt[i]=set.size(), i++);

		int lb = 0, ub = n-1;
		while(lb < ub) {
			int mid = lb+(ub-lb)/2;
			if(cnt[mid]-(lb==0?0:cnt[lb-1]) == mid-lb+1) lb = mid+1;
			else ub = mid;
		}
		return nums[lb];
	}







	/**find missing and repeating if array has 1 missing and 1 reapting 1...n**/

	// 1-  calc S and S^2 for both arr and 1...n
	// we have the formula n*(n+1)/2 and n*(n+1)*(2n+1)/6
	// calc x^2 - y^2 = (x-y)*(x+y) -> we get x+y, then putting
	// we have x+y, and x-y -> add them -> 2x = c -> x -> y

	// 2-  MLE!!! using sum-x+y and mult*y/x
	public int findDuplicate_v2(int[] nums) {
		int n = nums.length;
		long sum = n*(n+1)/2, mult = 1;
		for(int i = 1; i <= n; mult *= i, i++);

		// a = sum-x+y, b = mult*y/x, y is dubble, x is missing
		int a = 0, b = 1;
		for(int i : nums) {
			a += i;
			b *= i;
		}
		long x = mult*(a-sum)/(b-mult);
		long y = x + a-sum;
		return (int) y;
	}

	// 3-  xor
	public int findDuplicate_v3(int[] nums) {
		int n = nums.length;
		int xor = nums[0] ^ 1;
		for(int i = 2; i <= n; i++)
			xor = xor^i^nums[i-1];

		// get 1 set bit meaning a bit with val 1
		// 1 in xor mean that bit is set in either x or y
		// so divide elems based on that bit. If that bit is set in num[i]
		// then iss in x o.w. it's in y
		int bit = xor & ~(xor-1);
		int a = 0, b = 0;
		for(int i = 1; i <= n; i++) {
			if((nums[i-1] & bit) != 0)
				a ^= nums[i-1];
			else b ^= nums[i-1];

			if((i & bit) != 0) a ^= i;
			else b ^= i;
		}
		return Math.min(a,b);
	}
}