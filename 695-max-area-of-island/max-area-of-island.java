class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int count = 0;
                if(grid[i][j]==1 && !visited[i][j]) {
                    count = dfs(i, j, m, n, visited, grid);
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    private int dfs(int i, int j, int m, int n, boolean[][] visited, int[][] grid) {
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j]==0) return 0;
        visited[i][j] = true;
        return 1 + 
        dfs(i+1, j, m, n, visited, grid) + 
        dfs(i-1, j, m, n, visited, grid) +
        dfs(i, j+1, m, n, visited, grid) +
        dfs(i, j-1, m, n, visited, grid);
    }
}