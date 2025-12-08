class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++) {
            ans[i] = image[i].clone();
        }
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        dfs(image, ans, row, col, sr, sc, image[sr][sc], color);
        return ans;
    }
    private void dfs(int[][] grid, int[][] ans, int[] row, int[] col, int i, int j, int color, int newColor) {
        ans[i][j] = newColor;
        for(int k=0;k<4;k++) {
            if(i+row[k]>=0 && i+row[k]<grid.length && j+col[k]>=0 && j+col[k]<grid[0].length && grid[i+row[k]][j+col[k]]==color && ans[i+row[k]][j+col[k]]!=newColor) {
                dfs(grid, ans, row, col, i+row[k], j+col[k], color, newColor);
            }
        }
    }
}