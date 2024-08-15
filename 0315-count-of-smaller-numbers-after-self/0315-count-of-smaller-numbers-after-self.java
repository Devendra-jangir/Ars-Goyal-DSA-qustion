class Solution {
    public void merge(List<int[]> nums, int low, int mid, int high, int n, int[] count) {
        int i = low, j = mid + 1;
        List<int[]> temp = new ArrayList<>();
        int right = mid + 1;
        for (int left = low; left <= mid; left++) {
            while (right <= high && nums.get(left)[0] > nums.get(right)[0]) {
                right++;
            }
            count[nums.get(left)[1]] += (right - (mid + 1));
        }

        while (i <= mid && j <= high) {
            if (nums.get(i)[0] <= nums.get(j)[0]) {
                temp.add(nums.get(i));
                i++;
            } else {
                temp.add(nums.get(j));
                j++;
            }
        }
        while (i <= mid) {
            temp.add(nums.get(i));
            i++;
        }
        while (j <= high) {
            temp.add(nums.get(j));
            j++;
        }

        // Copy the sorted array into the original array
        for (int k = 0; k < temp.size(); k++) {
            nums.set(low + k, temp.get(k));
        }
    }

    public void mergeSort(List<int[]> nums, int l, int h, int n, int[] count) {
        if (l >= h) {
            return;
        }
        int mid = l + (h - l) / 2;
        mergeSort(nums, l, mid, n, count);
        mergeSort(nums, mid + 1, h, n, count);
        merge(nums, l, mid, h, n, count);
    }

    public List<Integer> countSmaller(int[] arr) {
        int n = arr.length;
        int[] count = new int[n];
        List<int[]> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(new int[]{arr[i], i});
        }
        mergeSort(nums, 0, n - 1, n, count);
        List<Integer> result = new ArrayList<>();
        for (int cnt : count) {
            result.add(cnt);
        }
        return result;
    }
}