

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, mapping[i]);
        }
        
        int l = 0;
        int[][] arr = new int[nums.length][2];
        
        // Process each number in nums
        for (int num : nums) {
            int mappedValue = getMappedValue(num, map);
            arr[l][0] = num;
            arr[l][1] = mappedValue;
            l++;
        }
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = arr[i][0];
        }
        
        return ans;
    }
    
    private int getMappedValue(int num, HashMap<Integer, Integer> map) {
        if (num == 0) return map.get(0);
        int result = 0;
        int factor = 1;
        
        while (num > 0) {
            int digit = num % 10;
            result = map.get(digit) * factor + result;
            factor *= 10;
            num /= 10;
        }
        
        return result;
    }
}
