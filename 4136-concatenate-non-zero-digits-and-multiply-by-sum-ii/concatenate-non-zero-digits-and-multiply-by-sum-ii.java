class Solution {

    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // prefix sum of digits
        long[] prefSum = new long[n + 1];

        // number of non-zero digits before each position
        int[] prefCnt = new int[n + 1];

        StringBuilder nz = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            prefSum[i + 1] = prefSum[i] + d;
            prefCnt[i + 1] = prefCnt[i];

            if (d != 0) {
                nz.append((char) ('0' + d));
                prefCnt[i + 1]++;
            }
        }

        int m = nz.length();

        long[] pow10 = new long[m + 1];
        long[] hash = new long[m + 1];

        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            hash[i + 1] = (hash[i] * 10 + (nz.charAt(i) - '0')) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefSum[r + 1] - prefSum[l];

            int left = prefCnt[l];
            int right = prefCnt[r + 1];
            int len = right - left;

            long num;

            if (len == 0) {
                num = 0;
            } else {
                num = (hash[right] - (hash[left] * pow10[len]) % MOD + MOD) % MOD;
            }

            ans[i] = (int) ((sum % MOD) * num % MOD);
        }

        return ans;
    }
}