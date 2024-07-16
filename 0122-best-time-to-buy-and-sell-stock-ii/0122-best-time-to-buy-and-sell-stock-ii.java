class Solution {
    public int maxProfit(int[] prices) {
        int bp = Integer.MAX_VALUE;
        int maxprofit = 0;
        int sum = 0;
        for(int i = 0; i<prices.length; i++){
            if(bp<prices[i]){
                sum += prices[i] - bp;
                bp = prices[i];
            }
            else{
                bp = prices[i];
            }
        }
        return sum;
    }
}