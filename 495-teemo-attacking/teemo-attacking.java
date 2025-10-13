class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisoned = 0;
        for(int i=0;i<timeSeries.length-1;i++) {
            if(timeSeries[i]+duration-1<timeSeries[i+1]) {
                poisoned += duration;
            } else {
                poisoned += (timeSeries[i+1]-timeSeries[i]);
            }
        }
        return poisoned+duration;
    }
}