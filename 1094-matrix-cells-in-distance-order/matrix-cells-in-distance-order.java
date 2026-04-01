class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows*cols][2];
        for (int i = 0; i < rows * cols; i++) {
            ans[i][0] = i / cols;
            ans[i][1] = i % cols;
        }
        Arrays.sort(ans, (a, b) -> {
            int distA = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int distB = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return distA - distB;
        });
        return ans;
    }
}