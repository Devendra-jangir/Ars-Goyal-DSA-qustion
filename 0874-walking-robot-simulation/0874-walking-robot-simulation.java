class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String>s = new HashSet<>();
        
        for(int i = 0; i<obstacles.length; i++){
            s.add(obstacles[i][0] + ","+ obstacles[i][1]);
        }
        
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int x = 0, y = 0;
        int d = 0;
        int max = 0;
        
        for(int cmd : commands){
            if(cmd == -1){
                d = (d+1)%4;
            }
            else if(cmd == -2){
                d = (d+3)%4; 
            }
            else{
                for(int i = 0; i<cmd; i++){
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];
                    
                    if(!s.contains(nx + ","+ny)){
                        x = nx; 
                        y = ny;
                        
                        max = Math.max(max, x*x+y*y);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return max;
    }
}