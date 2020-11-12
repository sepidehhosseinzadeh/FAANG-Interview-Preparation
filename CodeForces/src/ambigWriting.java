import java.util.*;

public class ambigWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String line = sc.nextLine();
            int res = 0;
            for(int i = 0; i < line.length();)
            {
                if(line.charAt(i) == 'w')
                    res++;
                else if(i+1 < line.length() && line.charAt(i+1) == 'v') {
                    res++;
                    i++;
                }

                i++;
            }
            System.out.println(res);
        }
    }
}
