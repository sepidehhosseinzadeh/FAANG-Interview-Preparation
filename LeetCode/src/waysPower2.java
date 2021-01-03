import java.util.*;

public class waysPower2 {
	public static void main(String[] args)
	{
		System.out.print(countPairs(new int[]{1,1,1,3,3,3,7}));
		System.out.print(countPairs(new int[]{64,64,64,64,64,64,64,64,64,64,64,64,64,
				64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64}));
	}
	static int mod = (int) (1e9+7);
	public static int countPairs(int[] d) {
		var cnt = new HashMap<Integer, Integer>();
		for(int i : d)
			cnt.put(i, cnt.getOrDefault(i, 0)+1);

		long res = 0;
		for(int i : cnt.keySet())
			for(int j : cnt.keySet()) {
				if(i == j && cnt.get(i) > 1 && ((2*i) & (2*i-1)) == 0) {
					res = res + cnt.get(i)*(cnt.get(i)-1)/2;
				}
				else if(i!=j && ((i+j) & (i+j-1)) == 0) {
					res = res + cnt.get(i) * cnt.get(j);
				}
			}
		return (int) (res)%mod;

	}
}
