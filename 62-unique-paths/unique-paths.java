class Solution {
    public int uniquePaths(int m, int n) {
        int min = Math.min(m, n) - 1;
        int max = m + n - 2;
        long x = 1;
        for (int i = 1; i <= min; i++) {
            x = x * (max - min + i) / i;
        }
        return (int)(x);
    }
}