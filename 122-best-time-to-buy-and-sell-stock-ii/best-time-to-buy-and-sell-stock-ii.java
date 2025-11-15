class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int x = 0;
        int y = 1;
        int profit = 0;
        while(y < prices.length) {
            if(prices[x]<prices[y]) {
                profit += (prices[y] - prices[x]);
                x = y;
                y += 1;
            } else {
                x = y;
                y += 1;
            }
        }
        return profit;
    }
}