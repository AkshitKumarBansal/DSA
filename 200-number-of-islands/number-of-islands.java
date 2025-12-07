class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] arr = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]=='1' && !arr[i][j]) {
                    count++;
                    dfs(grid, arr, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, boolean[][] arr,  int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0' || arr[i][j]) return;
        arr[i][j] = true;
        dfs(grid, arr, i, j-1);
        dfs(grid, arr, i, j+1);
        dfs(grid, arr, i-1, j);
        dfs(grid, arr, i+1, j);
    }
}