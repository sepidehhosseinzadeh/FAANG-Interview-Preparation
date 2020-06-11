import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.lang.reflect.Array;
import java.util.*;

public class tallestTowerPeople {
    /*
        17.8 Circus Tower: A circus is designing a tower routine
        consisting of people standing a top one another's shoulders.
        each person must be both shorter and lighter than the person below her.
        write a method to compute the largest possible number of people in
        such a tower.
     */
    static class Person implements Comparable<Person>
    {
        int w, h;
        Person(int w, int h)
        {
            this.w = w;
            this.h = h;
        }
        @Override
        public int compareTo(Person that)
        {
            return this.h-that.h;
        }

    }
    public static void main(String[] args) {

    }

    // O(2^n)
    static ArrayList<Person> getTallestTower(int at, ArrayList<Person> people,
                                             ArrayList<Person> tallestTillNow)
    {
        if(at == people.size())
            return tallestTillNow;

        ArrayList<Person> withAt = (ArrayList<Person>) tallestTillNow.clone();
        if (canPut(people, at, withAt)) {
        {
            withAt.add(people.get(at));
            withAt = getTallestTower(at + 1, people, withAt);
        }
        }
        ArrayList<Person> withoutAt = getTallestTower(at+1, people,
                                                                tallestTillNow);

        return withAt.size() > withoutAt.size() ? withAt : withoutAt;
    }

    static boolean canPut(ArrayList<Person> people, int at,
                                                     ArrayList<Person> res) {
        if(res.size() == 0)
            return true;
        Person last = res.get(res.size()-1);
        if(last.w < people.get(at).w && last.h < people.get(at).h)
            return true;

        return false;
    }

    // Iterative solution O(N^2) + O(nlog(n))
    // Find the longest subsequence that terminates with each element. Track the
    // longest overall subsequence as we go.
    static ArrayList<Person> getTallestTowerIter(int at, ArrayList<Person> people)
    {
        Collections.sort(people); // sort by h
        ArrayList<Person> tallest = new ArrayList<>();
        int maxN = 0;
        ArrayList<Person>[] tallestTower = new ArrayList[people.size()];
        for(int i = 0; i < people.size(); tallestTower[i] = new ArrayList<>(), i++);

        for(int last = 0; last < people.size(); last++)
        {
            int tallestIdx = -1, tallestH = -1;
            for(int i = 0; i < last; i++)
                if(canPut(people, last, tallestTower[i]))
                {
                    if(tallestH < tallestTower[i].size())
                    {
                        tallestIdx = i;
                        tallestH = tallestTower[i].size();
                    }
                }

            tallestTower[tallestIdx].add(people.get(last));
            if(maxN < tallestTower[tallestIdx].size())
            {
                maxN = tallestTower[tallestIdx].size();
                tallest = (ArrayList<Person>) tallestTower[tallestIdx].clone();
            }

        }
        return tallest;
    }
}
