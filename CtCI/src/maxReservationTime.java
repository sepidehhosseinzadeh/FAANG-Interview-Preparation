import java.util.*;

public class maxReservationTime {
    /*
    She needs a 15-minute break between appointments.
    Given a sequence of back-to-back appointment requests
    (all multiples of 15 minutes, none overlap, and none can be moved),
    find the highest total booked minutes the masseuse can honor.
    Return the number of minutes.
    */
    public static void main(String[] args)
    {
        int[] app = new int[]{30, 15, 60, 75, 45, 15, 15, 45};
        System.out.println(
                getMaxTime(app,0, Integer.MAX_VALUE, new int[app.length]));
        System.out.println(getMaxTimeIterOpt(app));
        System.out.println(getMaxTimeIterOptSpace(app));
    }
    public static int getMaxTime(int[] appTime, int at,
                                        int prevRestTime, int[] memo)
    {
        if(at >= appTime.length)
            return 0;

        if(memo[at] != 0)
            return memo[at];

        if(prevRestTime < 15)
            return 0;

        int withOutAt = getMaxTime(appTime, at+1,
    (prevRestTime==Integer.MAX_VALUE?0:prevRestTime)+appTime[at],memo);

        int withAt = appTime[at] + getMaxTime(appTime,at+2,
                (at+1 == appTime.length?Integer.MAX_VALUE:appTime[at+1]),memo);

        return memo[at] = Math.max(withAt, withOutAt);
    }
    static int getMaxTimeIterOpt(int[] appTime)
    {
        int n = appTime.length;
        int[] maxTimeTilNow = new int[n];
        maxTimeTilNow[0] = appTime[0];
        for(int at = 1; at < n; at++)
        {
            maxTimeTilNow[at] = Math.max((at>1?maxTimeTilNow[at-2]:0)+appTime[at],
                                            maxTimeTilNow[at-1]);
        }
        return maxTimeTilNow[n-1];
    }
    static int getMaxTimeIterOptSpace(int[] appTime)
    {
        int n = appTime.length;
        int Pat=0, Pat_1, Pat_2=0;
        Pat_1 = appTime[0];
        for(int at = 1; at < n; at++)
        {
            Pat = Math.max(Pat_2+appTime[at], Pat_1);
            Pat_2 = Pat_1;
            Pat_1 = Pat;
        }
        return Pat;
    }
}
