class Solution {
    public int largestAltitude(int[] gain) {
        int[] ans = new int[gain.length+1];
        for(int i=0;i<gain.length;i++) {
            ans[i+1] = gain[i]+ans[i]; 
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<ans.length;i++) {
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}