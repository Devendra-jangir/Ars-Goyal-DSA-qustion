class Solution {

    class Pair{
        int row;
        int col;
        Pair(int r,int c){
            this.row = r;
            this.col = c;
        }
    }
    public int minDays(int[][] grid){

        int number_of_islands=0;
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // Space - O(n*m)
        int n = grid.length;
        int m = grid[0].length;

        //Time -: O(n*m) every cell is being visited only onces.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(visited[i][j]==false && grid[i][j]==1){
                    dfs(i,j,grid,visited);
                    number_of_islands++;
                }
            }
        }
        if(number_of_islands>1 || number_of_islands==0) return 0;
        
        if(n==1 && m==2) return 2;
        if(m==1 && n==2) return 2;
        if(n==1 || m==1) return 1;

        visited = new boolean[grid.length][grid[0].length];
        List<Pair> list = new ArrayList<>(); // Space - : O(n*m) in the worst case;
        // Time -O(n*m)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) list.add(new Pair(i,j));
            }
        }
        if(list.size()==1) return 1;
        if(list.size()==n*m) return 2;
        
        // Time in the worst case = O(list.size()*n*m) or O(n*m*n*m)
        for(int ind=0;ind<list.size();ind++){

            Pair pair = list.get(ind);
            grid[pair.row][pair.col]=0;
            visited = new boolean[grid.length][grid[0].length];
            number_of_islands=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){

                  if(visited[i][j]==false && grid[i][j]==1){
                      dfs(i,j,grid,visited);
                      number_of_islands++;
                    }
                }
            }
            if(number_of_islands>1) return 1;
            grid[pair.row][pair.col]=1;
        }

        return 2;

    }
    // Plain DFS 
    // Recursion Stack Space-: O(n*m)
    void dfs(int row , int col , int[][] grid , boolean[][] visited){

        visited[row][col]=true;

        int[] r = {0,0,1,-1};
        int[] c = {1,-1,0,0};
        for(int i=0;i<4;i++){

            int rr = row+r[i];
            int cc = col+c[i];
            if(rr>=0 && rr<grid.length && cc>=0 && cc<grid[0].length && grid[rr][cc]==1 && visited[rr][cc]==false){
                dfs(rr,cc,grid,visited);
            }
        }
    }
}