class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                boolean flag = false;
                if(grid[i][j]==0 && visited[i][j]==false) {
                    flag = dfs(i, j, m, n, grid, visited);
                }
                if(flag) count++;
            }
        }
        return count;
    }
    private boolean dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited) {
        if(i<0 || j<0 || i>=m || j>=n) return false;
        if(grid[i][j]==1) return true;
        if(visited[i][j]) return true;
        visited[i][j] = true;
        boolean left   = dfs(i, j - 1, m, n, grid, visited);
        boolean right  = dfs(i, j + 1, m, n, grid, visited);
        boolean top    = dfs(i - 1, j, m, n, grid, visited);
        boolean bottom = dfs(i + 1, j, m, n, grid, visited);
        return left && right && top && bottom;
    }
}