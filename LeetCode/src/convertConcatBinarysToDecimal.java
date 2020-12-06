import java.util.*;

public class binary {
	int mod = (int) (1e9+7);
	public int concatenatedBinary(int n) {
		long res = 0;
		for(int i = 1; i <= n; i++) {
			res = concat(res, i)%mod;
		}
		return (int) res%mod;
	}
	public long concat(long m, long n)
	{
		int l = Long.toBinaryString(n).length();

		// left binary shift m and then add n
		return (long)((m << l) + n);
	}

	public int concatenatedBinary_v1(int n) {
		int len = 1;
		int threshold = 2;
		long res = 0;
		for (int i = 1; i <= n; i++) {
			if (i >= threshold) {
				len++;
				threshold <<= 1;
			}
			res = ((res << len) + i) % mod;
		}
		return (int) res;
	}
}
