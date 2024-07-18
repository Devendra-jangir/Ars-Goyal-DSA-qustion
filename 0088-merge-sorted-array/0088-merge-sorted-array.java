class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a1 = 0;
        int a2 = 0;
        
        while (a1 < m && a2 < n) {
            if (nums1[a1] > nums2[a2]) {
                // Shift nums1 elements to the right to make space for nums2 element
                for (int i = m; i > a1; i--) {
                    nums1[i] = nums1[i - 1];
                }
                nums1[a1] = nums2[a2];
                a2++;
                m++; // Increase the count of valid elements in nums1
            }
            a1++;
        }
        
        // If there are remaining elements in nums2, add them to nums1
        while (a2 < n) {
            nums1[m++] = nums2[a2++];
        }
    }
}
