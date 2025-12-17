class Solution {
    private int count = 0;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(arr[i][j]==0 && grid[i][j]=='1') {
                    count++;
                    dfs(i, j, arr, grid, m, n);
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j, int[][] arr, char[][] grid, int m, int n) {
        if(i<0 || j<0 || i>=m || j>=n || arr[i][j]==1 || grid[i][j]=='0') return;
        arr[i][j] = 1;
        dfs(i+1, j, arr, grid, m, n);
        dfs(i-1, j, arr, grid, m, n);
        dfs(i, j+1, arr, grid, m, n);
        dfs(i, j-1, arr, grid, m, n);
    }
}