class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int k = 1;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            else{
                nums[k++] = nums[i+1];
                count++;
            }
        }
        return count;
    }
}