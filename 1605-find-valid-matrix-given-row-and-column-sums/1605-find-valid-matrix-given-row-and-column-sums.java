class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length; 
        int m = colSum.length;
        
        int[][] ans = new int[n][m];
        
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<m; j++){
        //         ans[i][j]  = Math.min(rowSum[i], colSum[j]);
        //         rowSum[i] -= ans[i][j];
        //         colSum[j] -= ans[i][j];
        //     }
        // }
        
        for(int i = 0, j = 0; i < n && j < m;) {
            ans[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= ans[i][j];
            colSum[j] -= ans[i][j];
            if (rowSum[i] == 0) i++;
            if (colSum[j] == 0) j++;
        }
        return ans;

    }
}