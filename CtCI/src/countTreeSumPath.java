import java.util.*;

public class countTreeSumPath {
    static class treeNode
    {
        int val;
        treeNode left;
        treeNode right;
        treeNode(int val)
        {
            this.val = val;
        }
    }

    public static int countSumPath(treeNode t, int target, int curSum,
                                        HashMap<Integer, Integer> prevSumCount)
    {
        // count number of ways of sum(path)==s path is is parent -> a child

        if(t == null)
            return 0;

        curSum += t.val;

        int count = prevSumCount.getOrDefault(curSum-target, 0);

        if(curSum == target)
            count++;

        System.out.print(count+", "+curSum+"\n");

        prevSumCount.put(curSum, prevSumCount.getOrDefault(curSum,0)+1);

        count += countSumPath(t.left, target, curSum, prevSumCount);
        count += countSumPath(t.right, target, curSum, prevSumCount);

        prevSumCount.put(curSum, prevSumCount.get(curSum)-1);
        if(prevSumCount.get(curSum)==0) prevSumCount.remove(curSum);

        return count;

    }
    public static void main(String[] args)
    {
        treeNode t = new treeNode(10);
        t.left = new treeNode(5);
        t.right = new treeNode(-3);
        t.right.right = new treeNode(11);
        t.left.left = new treeNode(3);
        t.left.right = new treeNode(1);
        t.left.right.right = new treeNode(2);
        t.left.left.left = new treeNode(3);
        t.left.left.right = new treeNode(-2);

        int count = countSumPath(t, 8, 0, new HashMap<>()); // 3
        System.out.println("res: " + count);
    }
}
