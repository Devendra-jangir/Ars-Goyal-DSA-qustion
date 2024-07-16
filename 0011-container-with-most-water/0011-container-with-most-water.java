class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = Integer.MIN_VALUE;
        while(i<j){
            int w = Math.min(height[i], height[j]);
            int d = j-i;
            max = Math.max(max, w*d);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }
}