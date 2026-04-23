class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n<=1) return 0;
        int[] buy = new int[n+1];
        int[] sell = new int[n+1];
        for(int i=n-1;i>=0;i--) {
            for(int j=k;j>=1;j--) {
                int newBuy = Math.max(-prices[i]+sell[j], buy[j]);
                int newSell = Math.max(prices[i]+buy[j-1], sell[j]);
                buy[j] = newBuy;
                sell[j] = newSell;
            }
        }
        return buy[k];
    }
}