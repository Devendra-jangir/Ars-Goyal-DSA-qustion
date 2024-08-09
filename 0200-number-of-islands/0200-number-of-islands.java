class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        int g = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    g += checkIsland(grid, i, j, vis);
                }
            }
        }
        return g;
    }

    public int checkIsland(char[][] grid, int i, int j, boolean[][] vis) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] == '0') {
            return 0;
        }

        vis[i][j] = true;
        
        checkIsland(grid, i + 1, j, vis);
        checkIsland(grid, i - 1, j, vis);
        checkIsland(grid, i, j + 1, vis);
        checkIsland(grid, i, j - 1, vis);
        
        return 1;
    }
}
