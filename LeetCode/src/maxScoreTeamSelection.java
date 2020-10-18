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
        public int compareTo(node o)
        {
            if (this.age == o.age) return o.score - this.score;
            return this.age - o.age;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        node[] arr = new node[n];
        for (int i = 0; i < n; i++)
            arr[i] = new node(scores[i], ages[i]);
        Arrays.sort(arr);

        int maxS = 0;
        for (int j = 0; j < n; j++) {
            int prevS = arr[j].score, prevAge = arr[j].age;
            int s = arr[j].score;
            for (int i = j + 1; i < n; ) {
                int curMaxS = arr[i].score;
                while (i < n && arr[i].age == prevAge && arr[i].score > prevS) {
                    s += arr[i].score;
                    curMaxS = Math.max(curMaxS, arr[i].score);
                    i++;
                }
                if (i < n && arr[i].age != prevAge) {
                    s += arr[i].score;
                    curMaxS = arr[i].score;
                    prevAge = arr[i].age;
                    i++;
                }
                prevS = curMaxS;
            }
            maxS = Math.max(maxS, s);
        }

        return maxS;
    }
}