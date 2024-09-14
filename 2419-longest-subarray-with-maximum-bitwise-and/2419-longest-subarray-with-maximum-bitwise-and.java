class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        // Find the maximum element in the array
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        
        int longest = 0;
        int currentLength = 0;
        
        // Iterate through the array to find the longest subarray of max elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                currentLength++;  // Extend the current subarray of max elements
                longest = Math.max(longest, currentLength);
            } else {
                currentLength = 0;  // Reset the subarray length if a non-max element is found
            }
        }
        
        return longest;
    }
}
