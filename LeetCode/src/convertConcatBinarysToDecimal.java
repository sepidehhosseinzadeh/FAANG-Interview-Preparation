import java.util.*;

public class convertConcatBinarysToDecimal {
	int mod = (int) (1e9 + 7);

	public int concatenatedBinary_v0(int n) {
		long res = 0;
		for (int i = 1; i <= n; i++) {
			res = concat(res, i) % mod;
		}
		return (int) res % mod;
	}
	public long concat(long m, long n)
	{
		int l = Long.toBinaryString(n).length();

		// left binary shift m and then add n
		return (long) ((m << l) + n);
	}

	public int concatenatedBinary(int n) {
		long res = 0;
		int threshold = 2, len = 1;
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
