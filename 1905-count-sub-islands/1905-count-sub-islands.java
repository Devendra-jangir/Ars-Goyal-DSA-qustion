class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    
                    boolean[] isSubIsland = new boolean[] { true };
                    solver(grid1, grid2, i, j, isSubIsland);
                    if (isSubIsland[0]) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

    public void solver(int[][] grid1, int[][] grid2, int i, int j, boolean[] flag) {
        // Check boundaries and base cases
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || grid2[i][j] == 0) {
            return;
        }
        
       
        if (grid2[i][j] == 1 && grid1[i][j] == 0) {
            flag[0] = false;
        }

        
        grid2[i][j] = 0;
        
       
        solver(grid1, grid2, i + 1, j, flag);  // down
        solver(grid1, grid2, i - 1, j, flag);  // up
        solver(grid1, grid2, i, j + 1, flag);  // right
        solver(grid1, grid2, i, j - 1, flag);  // left
    }
}
