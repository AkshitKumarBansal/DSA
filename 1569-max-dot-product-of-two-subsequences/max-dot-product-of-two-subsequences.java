class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++) {
            int max1 = Integer.MIN_VALUE;
            for(int j=1;j<=n2;j++) {
                dp[i][j] = (nums1[i-1]*nums2[j-1]) + Math.max(0, dp[i-1][j-1]);
                if (i > 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
                if (j > 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n1;i++) {
            for(int j=1;j<=n2;j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}