class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; r++) {
            boolean[] seen = new boolean[n + 1];
            for (int c = 0; c < n; c++) {
                int val = matrix[r][c];
                if (seen[val]) return false;
                seen[val] = true;
            }
        }
        for (int c = 0; c < n; c++) {
            boolean[] seen = new boolean[n + 1];
            for (int r = 0; r < n; r++) {
                int val = matrix[r][c];
                if (seen[val]) return false;
                seen[val] = true;
            }
        }
        return true;
    }
}