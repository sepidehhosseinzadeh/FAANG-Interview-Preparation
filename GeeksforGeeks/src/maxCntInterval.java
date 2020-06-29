import java.util.*;
import java.lang.*;
import java.io.*;

class maxCntInterval {
    static class Pair implements Comparable<Pair>
    {
        double t;
        boolean start;

        public Pair(double t, boolean st)
        {
            this.t = t;
            start = st;
        }
        public int compareTo(Pair that)
        {
            return this.t - that.t >= 0 ? 1 : -1;
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            sc.nextLine();
            String[] st = sc.nextLine().trim().split("[ ]");
            String[] en = sc.nextLine().trim().split("[ ]");

            Pair[] time = new Pair[2*n];
            int i = 0, j = 0;
            while (true)
            {
                while (i < st.length && st[i].length() == 0) i++;
                if(i == st.length) break;

                time[j++] = new Pair(conv2double(st[i]), true);
                i++;
            }
            i = 0;
            while (true)
            {
                while (i < en.length && en[i].length() == 0) i++;
                if(i == en.length) break;
                time[j++] = new Pair(conv2double(en[i]), false);
                i++;
            }

            Arrays.sort(time);
            for(j= 0; j < time.length; j++)
                System.out.print("!"+time[j].t+"!");

            System.out.println(getmaxCoincide(time));
        }
    }
    static int getmaxCoincide(Pair[] time)
    {
        int n = time.length;
        if(n == 0)  return 0;
        if(n == 2)  return 1;

        int cnt = 0, maxN = 0;
        for(int i = 0; i < n; i++)
        {
            if(time[i].start)
                cnt++;
            else
                cnt--;
            maxN = Math.max(maxN, cnt);
        }

        return maxN;
    }
    static double conv2double(String s)
    {
        return ci(s.charAt(0))*10+ci(s.charAt(1))+
                ci(s.charAt(2))/10+ci(s.charAt(3))/100;
    }
    static double ci(char c)
    {
        return Double.parseDouble(c+"");
    }
}






