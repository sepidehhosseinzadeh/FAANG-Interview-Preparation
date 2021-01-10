import java.util.*;

public class jumpGameII {
	public int jump_v0(int[] nums) {
		int n = nums.length;
		int[] minJump = new int[n];
		Arrays.fill(minJump, Integer.MAX_VALUE);

		minJump[0] = 0;
		for(int i = 0; i < n; i++)
			for(int j = 1; j <= nums[i] && i+j < n; j++)
				minJump[i+j] = Math.min(minJump[i+j],
						minJump[i]+1);
		return minJump[n-1];
	}

	// BFS Tree: from each node, you can jump to children i+1...i+nJump[i],
	// the max of those defines level = 1 children, meaning that all those
	// nodes smaller or equal to max are still reachable by 1 jump.
	// so level = 1 for all those values.
	// level++ when we are passing the max val of previous node vals
	// the new maxLevel is the max value of the previous level children.
	public int jump(int[] nJump) {
		int n = nJump.length;
		int curMax = 0, levelMax = 0, level = 0;
		for(int i = 0; i < n-1; i++) {
			curMax = Math.max(curMax, i+nJump[i]);

			if(i == levelMax) {
				level++;
				levelMax = curMax;
			}
		}

		return level;
	}
}
