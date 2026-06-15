class SummaryRanges {
    private TreeSet<Integer> set;
    public SummaryRanges() {
        set = new TreeSet<>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>();
        if(set.isEmpty()) return new int[0][0];
        int start = set.first();
        int prev = start;
        for(int num : set) {
            if(num == start) continue;

            if(num == prev + 1) {
                prev = num;
            } else {
                list.add(new int[]{start, prev});
                start = num;
                prev = num;
            }
        }
        list.add(new int[]{start, prev});
        return list.toArray(new int[list.size()][]); 
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */