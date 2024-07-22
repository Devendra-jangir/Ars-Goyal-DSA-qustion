class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int[][] ans = new int[heights.length][2];
        
        for(int i=0; i<heights.length; i++){
            ans[i][0] = i;
            ans[i][1] = heights[i];
        }
        String[] arr = new String[heights.length];
        Arrays.sort(ans, (a,b)->b[1]-a[1]);
        for(int i= 0; i<heights.length; i++){
            arr[i] = names[ans[i][0]];
        }
        return arr;
    }
}