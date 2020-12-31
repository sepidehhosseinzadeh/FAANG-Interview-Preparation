import java.util.*;

public class celebrity {
/* The knows API is defined in the parent class Relation.*/
  	boolean knows(int a, int b) {return false;} // not implemented

	public int findCelebrity_v0(int n) {
		int[] outDegree = new int[n];
		int[] inDegree = new int[n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(knows(i, j)) {
					inDegree[j]++;
					outDegree[i]++;
				}

		for(int i = 0; i < n; i++)
			if(outDegree[i] == 1 && inDegree[i] == n) return i;

		return -1;
	}

	// o(n)
	// becuz there is only ONE celeb, then we can get the possible one
	// then later check if s/he is real
	public int findCelebrity(int n) {
		// possible celeb
		int c = 0;
		for(int i = 0; i < n; i++)
			if(knows(c, i)) c = i;
		// check if s/he is real celeb
		for(int i = 0; i < n; i++)
			if(c!=i && (knows(c, i) || !knows(i, c))) return -1;
		return c;
	}
}