public class rotateArray {

    class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            k--;
            reverse(nums, 0, nums.length-1);
            reverse(nums, 0, k);
            reverse(nums, k+1, nums.length-1);
        }
        void reverse(int[] arr, int i, int j)
        {
            int s = i, e = j;
            while(s < e)
            {
                int t = arr[s];
                arr[s] = arr[e];
                arr[e] = t;
                s++; e--;
            }
        }

    }
}
