import java.util.*;

public class waysPower2 {
	static int mod = (int) (1e9+7);

	// o(n^2) TLE
	public int countPairs_v0(int[] d) {
		var cnt = new HashMap<Integer, Integer>();
		for(int i : d)
			cnt.put(i, cnt.getOrDefault(i, 0)+1);

		long res = 0;
		for(int i : cnt.keySet()) {
			for(int j : cnt.keySet()) {
				if(i>0 && i==j && cnt.get(i) > 1 && ((2*i) & (2*i-1)) == 0) {
					res += (cnt.get(i)*(cnt.get(i)-1)/2)%mod;
				}
				else if(i!=j && cnt.get(i) > 0 && cnt.get(j) > 0 && ((i+j) & (i+j-1)) == 0) {
					res += (cnt.get(i) * cnt.get(j))%mod;
				}
			}
			cnt.put(i, 0);
		}
		return (int) (res%mod);

	}

	// o(32*n)=o(n)
	public int countPairs_v1(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		long res = 0;
		for (int num : arr) {
			int power = 1;
			for (int i = 0; i < 32; i++) {
				if (map.containsKey(power - num)) {
					res += map.get(power - num);
					res %= mod;
				}
				power *= 2;
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		return (int) res;
	}

	// count the number of ways in place:
	public int countPairs(int[] d) {
		var cnt = new HashMap<Integer, Integer>();
		for(int i : d)
			cnt.put(i, cnt.getOrDefault(i, 0)+1);
		long res = 0;
		for(int i : cnt.keySet()) {
			for(int j = 0, p = 1; j <= 21; j++, p*= 2)
				if(i <= p-i && cnt.containsKey(p-i)) { // i<=p-i: in order to not count twice
					if(i != p-i)
						res += 1L*cnt.get(i)*cnt.get(p-i)%mod;  // choose 1 from cnt[i] * choose 1 from cnt[p-i]
					else if(i+i == p && cnt.get(i) > 1)
						res += 1L*cnt.get(i)*(cnt.get(i)-1)/2%mod; // choose 2 from cnt[i]
					res %= mod;
				}
		}
		return (int) res;
	}
}
