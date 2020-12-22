import java.util.*;

public class findMissingAndRepeat {
	class Solution {
		public int findDuplicate_(int[] nums) {
			int n = nums.length;
			long sum = n*(n+1)/2, mult = 1;
			for(int i = 1; i <= n; mult *= i, i++);

			int a = 0, b = 1; // a = sum-x+y, b = mult*y/x, y is dubble, x is missing
			for(int i : nums) {
				a += i;
				b *= i;
			}
			long x = mult*(a-sum)/(b-mult);
			long y = x + a-sum;
			return (int) y;
		}

		public int findDuplicate(int[] nums) {
			int n = nums.length;
			int xor = nums[0] ^ 1;
			for(int i = 2; i <= n; i++)
				xor = xor^i^nums[i-1];

			int bit = xor & ~(xor-1); // ???
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
		//
	}
}
