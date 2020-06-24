import java.util.*;
/*
You are given an array A of size N.
Your task is to find the minimum number of operations
 needed to convert the given array to 'Palindromic Array'.
The only allowed operation is that you can
merge two adjacent elements in the array and replace them with their sum.
 */
public class palindromeOp {
        public static void main (String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            while(t-- > 0)
            {
                int n = scan.nextInt();
                int[] a = new int[n];
                for(int i = 0; i < n; i++)
                    a[i]=scan.nextInt();

                System.out.println(palinOp(a));
            }
        }
        public static int palinOp(int[] a)
        {
            int i = 0, j = a.length-1, count = 0;
            while(i < j)
            {
                if(a[i] == a[j])
                {
                    i++; j--;
                }
                else if(j > 0 && a[i] > a[j])
                {
                    a[j-1] += a[j];
                    j--;
                    count++;
                }
                else if(i+1 < a.length)
                {
                    a[i+1] += a[i];
                    i++;
                    count++;
                }
            }
            return count;
        }
    }
