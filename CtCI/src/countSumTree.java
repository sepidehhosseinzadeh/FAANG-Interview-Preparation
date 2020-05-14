import java.util.*;

public class countSumTree {
    static class treeNode
    {
        int val;
        treeNode left;
        treeNode right;
        treeNode(int v)
        {
            val = v;
        }
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

        System.out.println(countSum(t, 8, 0, new HashMap<>()));

    }

    static int countSum(treeNode t, int targetSum, int runnigSum,
                        HashMap<Integer, Integer> count)
    {
        if(t == null)   return 0;

        runnigSum += t.val;
        int sum = runnigSum - targetSum;
        int totalCount = count.getOrDefault(sum, 0);

        if(runnigSum == targetSum)  totalCount++;

        increamentCount(count, runnigSum, 1);
        totalCount += countSum(t.left, targetSum, runnigSum, count);
        totalCount += countSum(t.right, targetSum, runnigSum, count);
        increamentCount(count, runnigSum, -1);

        return totalCount;
    }
    static void increamentCount(HashMap<Integer, Integer> count, int key, int delta)
    {
        int val = count.getOrDefault(key, 0)+delta;
        if(val == 0)
            count.remove(key);
        else count.put(key, val);
    }
}

