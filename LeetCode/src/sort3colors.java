import java.util.*;

public class sort3colors {
	public void sortColors_v0(int[] nums) {
		int[] cnt = new int[3];
		for(int i : nums) cnt[i]++;
		for(int i = 2, k = nums.length-1; i >= 0; i--)
			for(int j = 0; j < cnt[i]; j++)
				nums[k--] = i;
	}

	public void sortColors(int A[]) {
		int j = 0, k = A.length-1;
		for (int i=0; i <= k; i++) {
			if (A[i] == 0)
				swap(A,i,j++);
			else if (A[i] == 2)
				swap(A,i--, k--);
		}
	}
	void swap(int[] a, int i, int j) {
		int t = a[i]; a[i] = a[j]; a[j]=t;
	}
}