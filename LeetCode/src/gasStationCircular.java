import java.util.*;

public class gasStationCircular {
	// sum of all s = gas[i]+cost[i] >= 0 we can reach.
	// index of start is when s is negative we can start from next,
	// because sum is >= 0 -> s >= 0 , s1+s2 >= 0 and s1 <0 -> s2-s1 >= 0
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int tank = 0, n = gas.length, idx = 0;
		int s = 0;
		for(int i = 0; i < n; i++) {
			tank += gas[i]-cost[i];
			s += gas[i]-cost[i];
			if(tank < 0) {
				tank = 0;
				idx = i+1;
			}
		}

		return s >= 0 ? idx : -1;
	}
}
