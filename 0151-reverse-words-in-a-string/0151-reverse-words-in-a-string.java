class Solution {
    public String reverseWords(String s) {
        // Trim leading and trailing spaces, then split by one or more spaces
        String[] arr = s.trim().split("\\s+");
        
        // Initialize pointers for the start and end of the array
        int i = 0;
        int j = arr.length - 1;
        
        // Reverse the words in the array
        while (i <= j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        
        // Use StringBuilder for efficient string concatenation
        StringBuilder ans = new StringBuilder();
        
        for (int c = 0; c < arr.length; c++) {
            ans.append(arr[c]);
            if (c < arr.length - 1) {
                ans.append(" ");
            }
        }
        
        return ans.toString();
    }
}
