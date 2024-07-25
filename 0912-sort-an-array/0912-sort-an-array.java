class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        int mid = start + (end - start) / 2;
        
        int[] left = Arrays.copyOfRange(nums, start, mid + 1);
        int[] right = Arrays.copyOfRange(nums, mid + 1, end + 1);
        
        return merge(sortArray(left), sortArray(right));
    }
    
    public int[] merge(int[] left, int[] right) {
        int n = left.length;
        int m = right.length;
        int[] ans = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < n && j < m) {
            if (left[i] < right[j]) {
                ans[k++] = left[i++];
            } else {
                ans[k++] = right[j++];
            }
        }
        while (i < n) {
            ans[k++] = left[i++];
        }
        while (j < m) {
            ans[k++] = right[j++];
        }
        return ans;
    }
}