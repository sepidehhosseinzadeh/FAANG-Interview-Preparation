class Solution {
    public int[] sortedSquares(int[] nums) {
        int m = 0, n = nums.length;
        while(m < n && nums[m] < 0) m++;
        
        int i = m-1, j = m, k = 0;
        int[] res = new int[n];
        while(i >= 0 || j < n) {
            int n1 = -1, n2 = -1;  
            if(i >= 0) n1 = nums[i]*nums[i];
            if(j < n) n2 = nums[j]*nums[j];
            if(n1 >= 0 && n2 >= 0) {
                if(n1 < n2) {
                    res[k++] = n1; i--;
                } else {
                    res[k++] = n2; j++;
                }
            } else if(n2 >= 0) {
                res[k++] = n2; j++;
            } else if(n1 >= 0) {
                res[k++] = n1; i--;
            } else break;
        }
        return res;
    }
}
