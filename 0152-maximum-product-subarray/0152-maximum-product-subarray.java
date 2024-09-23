class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i<nums.length; i++){
            int p = 1;
            int max = Integer.MIN_VALUE;
            for(int j = i; j<nums.length; j++){
                p *= nums[j];
                max = Math.max(max,p);
            }
            ans = Math.max(max,ans);
        }
        return ans;
    }
}