class StockSpanner {
    List<Integer> list;
    public StockSpanner() {
        list = new ArrayList<Integer>();
    }
    
    public int next(int price) {
        int count = 0;
        int i = list.size()-1;
        while(i>=0 && list.get(i)<=price) {
            i--;
            count++;
        }
        list.add(price);
        return count+1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */