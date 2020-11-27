import java.lang.reflect.Array;
import java.util.*;

public class cloneGraph {
    public static void main(String[] args)
    {
        var neigh1 = new ArrayList<Node>();
        neigh1.add(new Node(4));
        Node node1 = new Node(2, neigh1);

        var neigh = new ArrayList<Node>();
        neigh.add(node1);
        neigh.add(new Node(3));
        Node node = new Node(1, neigh);

        //cloneGraph(node);
    }
    // BFS
    public Node cloneGraph_v0(Node node) {
        if(node == null) return null;

        var map = new HashMap<Integer, Node>();
        var q = new LinkedList<Node>();
        q.add(node);
        map.put(node.val, new Node(node.val)); // work with node in map (the copy one)!!

        while(!q.isEmpty()) {
            Node at = q.poll();

            for(Node to : at.neighbors) {
                if(!map.containsKey(to.val)) {
                    q.add(to);
                    map.put(to.val, new Node(to.val));
                }
                map.get(at.val).neighbors.add(map.get(to.val)); // add neigh to at anyway!!!!
            }
        }

        return map.get(node.val);
    }

    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<Integer, Node>());
    }
    private Node clone(Node at, HashMap<Integer, Node> map)
    {
        if(at == null) return null;

        map.put(at.val, new Node(at.val));
        for(Node to : at.neighbors) {
            if(!map.containsKey(to.val))
                map.put(to.val, clone(to, map));
            map.get(at.val).neighbors.add(map.get(to.val));
        }

        return map.get(at.val);
    }
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
