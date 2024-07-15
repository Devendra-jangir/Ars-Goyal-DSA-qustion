class Solution {
    public int maxProfit(int[] prices) {
      int big = Integer.MAX_VALUE;
        int maxp = 0;
        
        for(int i =0; i<prices.length; i++){
            if(big <prices[i]){
                int profit = prices[i] - big;
                maxp = Math.max(maxp, profit);
            }
            else{
                big = prices[i];
            }
        }
        return maxp;
    }
}