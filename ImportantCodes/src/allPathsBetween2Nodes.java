import java.util.*;

public class allPathsBetween2Nodes {

    public static void main(String[] args) {
    }
    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList,
                                   List<Integer>[] adjList) {

        isVisited[u] = true;

        if (u.equals(d))
        {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            isVisited[u]= false;
            return ;
        }
        for (Integer i : adjList[u])
        {
            if (!isVisited[i])
            {
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList, adjList);
                localPathList.remove(i);
            }
        }

        isVisited[u] = false;
    }
}
