class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return solve(0, 0, m, n, grid, visited);
    }
    private boolean solve(int i, int j, int m, int n, int[][] grid, boolean[][] visited) {
        if(i==m-1 && j==n-1) return true;
        if(i>=m || j>=n || i<0 || j<0 || visited[i][j]) return false;
        visited[i][j] = true;
        boolean res = false;
        if (grid[i][j] == 1) {
            if (j - 1 >= 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
                res |= solve(i, j - 1, m, n, grid, visited);
            }
            if (j + 1 < n && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
                res |= solve(i, j + 1, m, n, grid, visited);
            }
        } else if (grid[i][j] == 2) {
            if (i - 1 >= 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)) {
                res |= solve(i - 1, j, m, n, grid, visited);
            }
            if (i + 1 < m && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
                res |= solve(i + 1, j, m, n, grid, visited);
            }
        } else if (grid[i][j] == 3) {
            if (j - 1 >= 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
                res |= solve(i, j - 1, m, n, grid, visited);
            }
            if (i + 1 < m && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
                res |= solve(i + 1, j, m, n, grid, visited);
            }
        } else if (grid[i][j] == 4) {
            if (j + 1 < n && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
                res |= solve(i, j + 1, m, n, grid, visited);
            }
            if (i + 1 < m && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
                res |= solve(i + 1, j, m, n, grid, visited);
            }
        } else if (grid[i][j] == 5) {
            if (j - 1 >= 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
                res |= solve(i, j - 1, m, n, grid, visited);
            }
            if (i - 1 >= 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)) {
                res |= solve(i - 1, j, m, n, grid, visited);
            }
        } else {
            if (j + 1 < n && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
                res |= solve(i, j + 1, m, n, grid, visited);
            }
            if (i - 1 >= 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)) {
                res |= solve(i - 1, j, m, n, grid, visited);
            }
        }
        return res;
    }
}