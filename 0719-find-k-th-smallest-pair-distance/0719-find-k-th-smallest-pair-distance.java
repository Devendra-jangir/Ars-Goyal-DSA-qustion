class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1] - nums[0];
        
        while(left<= right){
            int mid = left + (right-left)/2;
            if(iscountofDistance(nums, k , mid)){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    } 
    public boolean iscountofDistance(int[] nums,int k ,int mid){
        int c = 0; 
        int left = 0;
        for(int r = 1; r<nums.length; r++){
            while(nums[r]- nums[left]>mid) left++;
            c += r - left;
        }
        
        if(c>=k){
            return true;
        }
        return false;
    }
}