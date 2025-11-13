class Solution {
    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE;
        int ind = 0;
        for(int i=0;i<prices.length;i++) {
            if(min > prices[i]) {
                min = Math.min(min, prices[i]);
                ind = i;
            }
        }
        int smin = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++) {
            if(smin > prices[i] && i != ind) {
                smin = Math.min(smin, prices[i]);
            }
        }
        if(min+smin <= money) return money-(min+smin);
        return money;
    }
}