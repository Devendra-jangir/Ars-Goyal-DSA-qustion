class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0; 
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (checkMagic(grid, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public boolean checkMagic(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || seen[grid[i][j]]) {
                    return false;
                }
                seen[grid[i][j]] = true;
            }
        }
        
        int targetSum = grid[row][col] + grid[row][col+1] + grid[row][col+2];
        
        // Check rows
        for (int i = row; i < row + 3; i++) {
            if (grid[i][col] + grid[i][col+1] + grid[i][col+2] != targetSum) {
                return false;
            }
        }
        
        // Check columns
        for (int j = col; j < col + 3; j++) {
            if (grid[row][j] + grid[row+1][j] + grid[row+2][j] != targetSum) {
                return false;
            }
        }
        int ld = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int rd = grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col];
        
        if (ld != targetSum || rd != targetSum) {
            return false;
        }
        
        return true;
    }
}
