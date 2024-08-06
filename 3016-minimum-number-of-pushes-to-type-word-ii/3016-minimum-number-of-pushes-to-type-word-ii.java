class Solution {
    public int minimumPushes(String word) {
        Integer[] arr = new Integer[26];
        Arrays.fill(arr, 0);
        for(int i = 0; i<word.length(); i++){
            arr[word.charAt(i) - 'a']++;
        }
        
        Arrays.sort(arr, (a,b)->b-a);
        int digit = 0;
        int ans = 0;
        for(int freq : arr){
            ans += (digit/8 + 1)*freq;
            digit++;
        }
        return ans;   
    }
}