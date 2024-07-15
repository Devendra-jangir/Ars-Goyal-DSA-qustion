import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Initialize the answer array
        int[] ans = new int[2];
        
        // HashMap to store the indices of the elements
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                // If the complement exists, return the indices
                ans[0] = map.get(complement);
                ans[1] = i;
                return ans;
            }
            // Store the index of the current element
            map.put(nums[i], i);
        }
        
        // Return default values if no solution is found
        return ans;
    }
}
