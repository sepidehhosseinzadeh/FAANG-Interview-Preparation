import java.util.*;

public class pow {
	public double myPow(double x, int n) {
		if(n == -1) return 1.0/x;
		if(n == 0) return 1;
		if(n == 1) return x;

		double p = myPow(x, n/2);
		if(n%2 != 0) return n>0 ? p*p*x : p*p/x;
		return p*p;
	}
}