class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int total = 0;
        for(int i = 0; i<n; i++){
            int rm = 0, rl = 0, lm = 0, ll = 0;
            
            for(int j = i+1; j<n; j++){
                if(rating[i]<rating[j]){
                    rm++;
                }
                else{
                    rl++;
                }
            }
            
            for(int j = 0; j<i; j++){
                if(rating[i]>rating[j]){
                    ll++;
                }
                else{
                    lm++;
                }
            }
            total += rm*ll + lm*rl;
        }
        return total;
    }
    
}