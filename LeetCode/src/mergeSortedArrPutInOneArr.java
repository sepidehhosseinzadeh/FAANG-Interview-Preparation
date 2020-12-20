import java.util.*;

public class mergeSortedArrPutInOneArr {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = n+m-1;
		int j = n-1, k = m-1;
		while(j >= 0 && k >= 0)
			if(nums1[k] < nums2[j]) nums1[i--] = nums2[j--];
			else nums1[i--] = nums1[k--];

		while(j >= 0) nums1[i--] = nums2[j--];

		while(k >= 0) nums1[i--] = nums1[k--];
	}
}
