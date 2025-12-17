class Solution {
    private int count = 0;
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] arr = new int[m][n];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(arr[i][j]==0 && grid[i][j]==1) {
                    dfs(i, j, arr, grid, m, n);
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j, int[][] arr, int[][] grid, int m, int n) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) {
            count += 1;
            return;
        }
        if(arr[i][j] == 1) return;
        arr[i][j] = 1;
        dfs(i+1, j, arr, grid, m, n);
        dfs(i-1, j, arr, grid, m, n);
        dfs(i, j+1, arr, grid, m, n);
        dfs(i, j-1, arr, grid, m, n);
    }
}