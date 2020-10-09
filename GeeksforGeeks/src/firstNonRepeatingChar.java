import java.util.*;

public class firstNonRepeatingChar {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] input = sc.nextLine().split("[ ]");

            //HashMap<String, Integer> cnt = new HashMap<>();
            int[] cnt = new int[26];
            Queue<Integer> one = new LinkedList<>();

            for (int i = 0; i < n; i++)
            {
                int ch = input[i].charAt(0)-'a';
                //cnt.put(ch, cnt.getOrDefault(ch, 0)+1);
                cnt[ch]++;

                //if(cnt.get(ch) == 1)
                if(cnt[ch] == 1)
                    one.add(ch);
                while(!one.isEmpty() && cnt[one.peek()] > 1)
                    one.remove();

                if(one.isEmpty())
                    System.out.print(-1+" ");
                else
                    System.out.print((char)(one.peek()+'a')+" ");
            }

            System.out.println();
        }
    }
}