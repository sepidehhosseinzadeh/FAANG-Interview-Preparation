class ZigzagIterator_v0 {
    Queue<Queue<Integer>> qs;
    public ZigzagIterator_v0(List<Integer> v1, List<Integer> v2) {
        qs = new LinkedList<>();
        if(!v1.isEmpty()) qs.add(new LinkedList<Integer>(v1)); 
        if(!v2.isEmpty()) qs.add(new LinkedList<Integer>(v2));
    }

    public int next() {
        Queue<Integer> q = qs.poll();
        int ret = q.poll();
        if(!q.isEmpty()) qs.add(q);
        return ret;
    }

    public boolean hasNext() {
        return !qs.isEmpty();
    }
}

public class ZigzagIterator {
    Queue<Iterator<Integer>> q;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        if(!v1.isEmpty()) q.add(v1.iterator());
        if(!v2.isEmpty()) q.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> iter = q.poll();
        int ret = iter.next();
        if(iter.hasNext()) q.add(iter);
        return ret;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
