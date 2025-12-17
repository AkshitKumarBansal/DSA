class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int C = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        int[][] arr = new int[m][n];
        dfs(sr, sc, arr, image, color, C, m, n);
        return image;
    }
    private void dfs(int i, int j, int[][] arr, int[][] image, int newC, int C, int m, int n) {
        if(i<0 || j<0 || i>=m || j>=n || image[i][j]!=C || arr[i][j]==1) return;
        if(image[i][j]==C) {
            image[i][j] = newC;
        }
        arr[i][j] = 1;
        dfs(i+1, j, arr, image, newC, C, m, n);
        dfs(i-1, j, arr, image, newC, C, m, n);
        dfs(i, j+1, arr, image, newC, C, m, n);
        dfs(i, j-1, arr, image, newC, C, m, n);
    }
}