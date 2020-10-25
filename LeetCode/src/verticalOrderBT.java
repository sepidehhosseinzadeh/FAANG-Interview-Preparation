import java.util.*;

public class verticalOrderBT {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
                new TreeMap<>();

        view(root, 0, 0, map);

        List<List<Integer>> res = new ArrayList<>();

        // for(int w : map.keySet())
        // {
        //     ArrayList<Integer> hm = new ArrayList<>();
        //     for(int h : map.get(w).keySet())
        //         for(int i : map.get(w).get(h)) // WORNG!!!!! Adds the elements with no order!
        //             hm.add(i);
        //     res.add(hm);
        // }

        for (int w : map.keySet()) {
            ArrayList<Integer> hm = new ArrayList<>();
            for (int h : map.get(w).keySet()) {
                PriorityQueue<Integer> q = map.get(w).get(h);
                while (!q.isEmpty())
                    hm.add(q.poll());
            }
            res.add(hm);
        }

        // for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
        //     res.add(new ArrayList<>());
        //     for (PriorityQueue<Integer> nodes : ys.values()) {
        //         while (!nodes.isEmpty()) {
        //             res.get(res.size() - 1).add(nodes.poll());
        //         }
        //     }
        // }

        return res;
    }

    void view(TreeNode at, int w, int h,
              TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map)
    {
        if (at == null) return;

        TreeMap<Integer, PriorityQueue<Integer>> wm =
                map.getOrDefault(w, new TreeMap<>());
        PriorityQueue<Integer> hq = wm.getOrDefault(h, new PriorityQueue<>());
        hq.add(at.val);

        wm.put(h, hq);
        map.put(w, wm);

        view(at.left, w - 1, h + 1, map);
        view(at.right, w + 1, h + 1, map);
    }
}