import java.util.*;

public class colorGraphing {
    public static void main(String[] args)
    {
    }
    class solve {
        public boolean graphColoring(List<Integer>[] G,
                      int[] color, int i, int C) {

            if(i == G.length)
                return true;

            if(color[i] == 0)
                for(int c = 1; c <= C; c++)
                    if(isSafe(c, color, G[i]))
                    {
                        color[i] = c;
                        if(graphColoring(G,color,i+1,C))
                            return true;
                        color[i] = 0;
                    }
            return false;

        }
        boolean isSafe(int c, int[] color, List<Integer> G)
        {
            for(int k = 0; k < G.size(); k++)
                if(color[G.get(k)] == c)
                    return false;
            return true;
        }
    }
}
