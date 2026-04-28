class Solution {
    public int minOperations(int[][] grid, int x) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m*n];
        int k = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                arr[k++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int target = arr[(m*n)/2];
        for(int i=0;i<arr.length;i++) {
            int diff = Math.abs(arr[i]-target);
            if(diff%x!=0) return -1;
            res += diff/x;
        }
        return res;
    }
}

//Optimized Approach