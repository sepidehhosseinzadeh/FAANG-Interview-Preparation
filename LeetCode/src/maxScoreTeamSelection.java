import java.util.*;

public class maxScoreTeamSelection {
    static class node implements Comparable<node> {
        int score, age;

        node(int s, int a)
        {
            score = s;
            age = a;
        }

        @Override
        // THIS IS FOR MEMO APPROCH
        // public int compareTo(node o)
        // {
        //     return score != o.score ? score - o.score : age - o.age;
        // }

        // THIS IS FOR DP APPROCH
        public int compareTo(node o)
        {
            return age != o.age ? age - o.age : score - o.score;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        node[] arr = new node[n];
        for (int i = 0; i < n; i++)
            arr[i] = new node(scores[i], ages[i]);
        Arrays.sort(arr);

        int[][] memo = new int[n][1001];
        for (int[] a : memo)
            Arrays.fill(a, -1);

        //return bestScore(0, 0, arr, memo);
        return bestScoreDP(arr);
    }

    int bestScore(int at, int prevmaxAge, node[] arr, int[][] memo)
    {
        if (at == arr.length) return 0;
        if (memo[at][prevmaxAge] != -1) return memo[at][prevmaxAge];

        int wAt = 0, woAt = 0;
        if (arr[at].age >= prevmaxAge)
            wAt = arr[at].score + bestScore(at + 1, arr[at].age, arr, memo);

        woAt = bestScore(at + 1, prevmaxAge, arr, memo);

        return memo[at][prevmaxAge] = Math.max(wAt, woAt);
    }

    int bestScoreDP(node[] arr)
    {
        int n = arr.length;
        Arrays.sort(arr);

        int[] bestScore = new int[n];

        // max sum increasing subsequence
        int maxS = 0;
        for (int i = 0; i < n; i++) {
            bestScore[i] = arr[i].score;
            for (int j = 0; j < i; j++)
                if (arr[j].score <= arr[i].score)
                    bestScore[i] = Math.max(bestScore[i],
                            bestScore[j] + arr[i].score);
            maxS = Math.max(maxS, bestScore[i]);
        }
        return maxS;
    }
}
