class Solution {
    public int majorityElement(int[] nums) {
        int e = nums[0];
        int c = 1;
        
        for(int i = 1; i<nums.length; i++){
            if(c==0 && nums[i] != e){
                e = nums[i];
            }
            if(nums[i] != e && c>=1){
                c--;
            }
            if(nums[i] ==e){
                c++;
            }
        }
        
        return e;
        
    }
}