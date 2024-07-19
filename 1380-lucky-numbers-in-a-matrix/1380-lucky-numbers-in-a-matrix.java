class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer>ans = new ArrayList<>();
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(isminimum(matrix, i, j, matrix[i][j])){
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
        
    }
    public boolean isminimum(int[][] arr, int r, int c, int val){
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i<m; i++){
            if(arr[r][i]<val){
                return false;
            }
        }
        for(int i = 0; i<n; i++){
            if(arr[i][c]>val){
                return false;
            }
        }
        return true;
    }
}