import java.util.*;

public class primeCount {
	public int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];

		int cnt = 0;
		for(int j = 2; j < n; j++)
			if(!notPrime[j]) {
				cnt++;
				for(int i = 2*j; i < n; i+=j)
					notPrime[i] = true;
			}

		return cnt;

	}
}