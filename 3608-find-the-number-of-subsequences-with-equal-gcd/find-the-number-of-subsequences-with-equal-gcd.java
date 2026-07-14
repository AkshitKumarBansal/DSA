class Solution {
    private int[][][] dp;
    private int[][] gcdTable = new int[201][201];
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;

        dp = new int[n + 1][201][201];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= 200; j++)
                Arrays.fill(dp[i][j], -1);

        for (int i = 0; i <= 200; i++)
            for (int j = 0; j <= 200; j++)
                gcdTable[i][j] = gcd(i, j);

        return solve(nums, 0, 0, 0);
    }

    private int solve(int[] nums, int i, int g1, int g2) {
        if (i == nums.length)
            return (g1 != 0 && g1 == g2) ? 1 : 0;

        if (dp[i][g1][g2] != -1)
            return dp[i][g1][g2];

        long ans = solve(nums, i + 1, g1, g2);

        ans += solve(nums, i + 1, gcdTable[g1][nums[i]], g2);

        ans += solve(nums, i + 1, g1, gcdTable[g2][nums[i]]);

        return dp[i][g1][g2] = (int)(ans % MOD);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}