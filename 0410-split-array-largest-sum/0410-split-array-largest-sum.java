class Solution {
    public int splitArray(int[] nums, int k) {
        int start = Integer.MIN_VALUE;
        int last = 0;
        
        for (int i = 0; i < nums.length; i++) {
            last += nums[i];
            start = Math.max(start, nums[i]);
        }
        
        int res = 0;
        while (start <= last) {
            int mid = start + (last - start) / 2;
            if (ispossible(nums, k, mid)) {
                res = mid;
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
    
    public boolean ispossible(int[] nums, int k, int target) {
        int sum = 0;
        int arraycount = 1;  // Start with one subarray.
        
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= target) {
                sum += nums[i];
            } else {
                arraycount++;
                if (arraycount > k) {
                    return false;
                }
                sum = nums[i];  
            }
        }
        return true;  
    }
}
