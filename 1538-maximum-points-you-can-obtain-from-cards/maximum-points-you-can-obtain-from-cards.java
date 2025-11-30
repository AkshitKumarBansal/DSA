class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int i=0;i<k;i++) {
            sum += cardPoints[i];
        }
        int i = cardPoints.length-k;
        int j = cardPoints.length;
        int max = sum;
        sum = 0;
        for(int x=i;x<j;x++) {
            sum += cardPoints[x];
        }
        max = Math.max(max, sum);
        i++;
        while(j<cardPoints.length+k-1) {
            sum = sum - cardPoints[i-1] + cardPoints[j-cardPoints.length];
            max = Math.max(max, sum);
            i++;
            j++;
        }
        return max;
    }
}