import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

public class TEST {
	public static void main(String[] args)
	{
		System.out.println(isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 3));
		System.out.println(isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 1));
		System.out.println(isNStraightHand(new int[] {1,2,3,6,3,3,4,7,8}, 3));
	}

	public static boolean isNStraightHand(int[] hand, int w) {
		Arrays.sort(hand);
		if (hand.length < w * w) return false;

		HashMap<Integer, Integer> cnt = new HashMap<>();
		for (int i : hand) cnt.put(i, cnt.getOrDefault(i, 0) + 1);

		for (int i = 0; i < w; i++) {
			int pre = -1, count = 0;
			for (int j : cnt.keySet()) {
				if(cnt.get(j) == 0) continue;
				if (pre != -1 && j != pre + 1) return false;
				pre = j;
				cnt.put(j, cnt.get(j) - 1);
				count++;
				if (count == w) break;
				//cnt.remove(j, 0);
			}
		}
		return true;
	}
}
