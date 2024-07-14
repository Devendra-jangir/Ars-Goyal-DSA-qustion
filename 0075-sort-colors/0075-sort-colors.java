class Solution {
    public void sortColors(int[] arr) {
        int s = 0;
        int mid = 0;
        int hi = arr.length - 1;
        
        while (mid <= hi) {
            switch (arr[mid]) {
                case 0: {
                    int temp = arr[s];
                    arr[s] = arr[mid];
                    arr[mid] = temp;
                    s++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    int temp = arr[mid];
                    arr[mid] = arr[hi];
                    arr[hi] = temp;
                    hi--; 
                    break;
                }
            }
        }
    }
}
