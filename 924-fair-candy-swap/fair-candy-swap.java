class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int countA = 0;
        int countB = 0;
        Set<Integer> set = new HashSet<>();
        for(int x : aliceSizes) {
            countA += x;
            set.add(x);
        }
        for(int x : bobSizes) countB += x;
        int each = (countA-countB)/2;
        for(int x : bobSizes) {
            int y = each+x;
            if(set.contains(y)) return new int[]{y, x};
        }
        return new int[]{-1, -1};
    }
}