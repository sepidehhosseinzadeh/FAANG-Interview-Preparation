import java.util.*;

public class OrderedStreamMem {
    public static void main(String[] args)
    {
        OrderedStream orderedStream = new OrderedStream(5);
        List<String> res = orderedStream.insert(3, "ccccc");
        List<String> res1 = orderedStream.insert(1, "aaa");
        List<String> res2 = orderedStream.insert(2, "bbb");
        List<String> res3 = orderedStream.insert(5, "eee");
        List<String> res4 = orderedStream.insert(4, "ddd");

    }

    static class OrderedStream {
        int ptr;
        String[] mem;

        public OrderedStream(int n) {
            mem = new String[n];
            Arrays.fill(mem, "");
            ptr = 0;
        }

        public List<String> insert(int id, String value) {
            id--;
            mem[id] = value;

            var res = new ArrayList<String>();
            while (ptr < mem.length && !mem[ptr].equals("")) {
                res.add(mem[ptr]);
                ptr++;
            }

            return res;
        }
    }
}
