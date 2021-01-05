import java.util.*;

public class median2sortedList {
	// if we add all two lists in one, we are looking for a num (or two)
	// in the middle after merged sorted lists. We can use binary search
	// to find a partition that nLA+nLB==nRA+nRB and max of all left part is less-eq than right part.
	// binary search on len of one array, then the other arr's len is (n+m+1)/2-len
	// Two lists are sorted, we can work with min/max of half partitions
	// if maxLA <= minRB && maxLB <= minRA the partition is found
	// o.w. shrink/expand B (smaller one)
	public double findMedianSortedArrays(int[] A, int[] B) {
		int n = A.length, m = B.length;
		int MIN = Integer.MIN_VALUE;
		int MAX = Integer.MAX_VALUE;
		if(n < m) return findMedianSortedArrays(B, A);

		// binary search on B's len (smaller list)
		int lb = 0, ub = m;
		while(lb <= ub) {
			int mid = lb+(ub-lb)/2;
			int nLB = mid, nLA = (n+m+1)/2-nLB;

			int maxLB = nLB==0 ? MIN : B[nLB-1];
			int minRB = nLB==m ? MAX : B[nLB];
			int maxLA = nLA==0 ? MIN : A[nLA-1];
			int minRA = nLA==n ? MAX : A[nLA];

			if(maxLA <= minRB && maxLB <= minRA) { // found it
				if((n+m) % 2 == 0)
					return 1.0*(Math.max(maxLA,maxLB)+Math.min(minRA,minRB))/2.0;
				else return Math.max(maxLA,maxLB);
			}
			else if(maxLA > minRB) lb = mid+1;
			else ub = mid-1;
		}

		return -1;
	}
}