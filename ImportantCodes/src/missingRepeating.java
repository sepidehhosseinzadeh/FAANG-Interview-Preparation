import java.util.*;

/*
Given an unsorted array of size N of positive integers.
One number from set {1, 2,..., N} is missing and one number occurs twice in array.
Find these two numbers.
 */
public class missingRepeating {
    public static void main(String[] args)
    {
    }
    static void find(int[] arr, int n)
    {
        int xor1 = 0;
        for(int i = 1; i <= n; i++)
            xor1 ^= i^arr[i-1];

        int lastBit = xor1 & ~(xor1-1);
        int x = 0, y = 0;
        for(int i = 1; i <= n; i++)
        {
            if((arr[i-1] & lastBit) != 0)
                x ^= arr[i-1];
            else
                y ^= arr[i-1];

            if((i & lastBit) != 0)
                x ^= i;
            else
                y ^= i;
        }

        System.out.println(y+" "+x);
    }
}
/*
Below are various methods to solve the problems:

Method 1 (Use Sorting)
Approach:
Sort the input array.
Traverse the array and check for missing and repeating.
Time Complexity: O(nLogn)

Method 2 (Use count array)
Approach:
Create a temp array temp[] of size n with all initial values as 0.
Traverse the input array arr[], and do following for each arr[i]
if(temp[arr[i]] == 0) temp[arr[i]] = 1;
if(temp[arr[i]] == 1) output “arr[i]” //repeating
Traverse temp[] and output the array element having value as 0
(This is the missing element)
Time Complexity: O(n)
Auxiliary Space: O(n)

Method 3 (Use elements as Index and mark the visited places)
Approach:
Traverse the array. While traversing, use the absolute value of every element
as an index and make the value at this index as negative to mark it visited.
 If something is already marked negative then this is the repeating element.
 To find missing, traverse the array again and look for a positive value.

Method 4 (Make two equations)
Approach:
Let x be the missing and y be the repeating element.
Get the sum of all numbers using formula S = n(n+1)/2 – x + y
Get product of all numbers using formula P = 1*2*3*…*n * y / x
The above two steps give us two equations, we can solve the equations and
get the values of x and y.
Time Complexity: O(n)
Note: This method can cause arithmetic overflow as we calculate product and
sum of all array elements.

Method 5 (Use XOR)
Approach:
Let x and y be the desired output elements.
Calculate XOR of all the array elements.
xor1 = arr[0]^arr[1]^arr[2]…..arr[n-1]

XOR the result with all numbers from 1 to n
xor1 = xor1^1^2^…..^n

In the result xor1, all elements would nullify each other except x and y.
All the bits that are set in xor1 will be set in either x or y.
So if we take any set bit (We have chosen the rightmost set bit in code) of
xor1 and divide the elements of the array in two sets – one set of elements
with same bit set and other set with same bit not set.
By doing so, we will get x in one set and y in another set.
Now if we do XOR of all the elements in first set, we will get x, and
by doing same in other set we will get y.
 */