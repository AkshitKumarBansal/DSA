class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] arr = new boolean[isConnected.length];
        int count = 0;
        for(int i=0;i<isConnected.length;i++) {
            if(!arr[i]) {
                count++;
                dfs(isConnected, arr, i);
            }
        }
        return count;
    }
    private void dfs(int[][] matrix, boolean[] arr, int n) {
        arr[n] = true;
        for(int i=0;i<matrix[n].length;i++) {
            if(matrix[n][i]==1 && !arr[i]) dfs(matrix, arr, i);
        }
    }
}