public class ZigzagIterator {
    Queue<Queue<Integer>> qs;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
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

class ZigzagIterator_ {
    Queue<Iterator<Integer>> queue; 
    public ZigzagIterator_(List<Integer> v1, List<Integer> v2) {
        this.queue = new LinkedList<Iterator<Integer>> ();
        if(v1.iterator().hasNext()) 
            queue.offer(v1.iterator());
        if(v2.iterator().hasNext()) 
            queue.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> next = queue.poll();
        int a  = next.next();
        if(next.hasNext()) queue.offer(next);
        return a;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */