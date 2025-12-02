class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length) return -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int x : bloomDay) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        int i = min;
        int j = max;
        while(i<j) {
            int mid = (j-i)/2 + i;
            if(Days(bloomDay, mid, m, k)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return Days(bloomDay, i, m, k) ? i : -1;
    }
    private boolean Days(int[] bloomDay, int x, int m, int k) {
        int count = 0;
        for(int i=0;i<bloomDay.length;i++) {
            if(bloomDay[i]<=x) {
                count++;
                if(count==k) {
                    m--;
                    count = 0;
                    if(m == 0) return true;
                }
            } else {
                count = 0;
            }
        }
        return m == 0;
    }
}