class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++) {
            int l = 0, r = n-1;
            while(l<=r) {
                if(grid[i][l]<=-1) {
                    count += (n-l);
                    break;
                }
                int mid = (r+l)/2;
                if(grid[i][mid]>-1) l = mid+1;
                else r = mid;
            }
        }
        return count;
    }
}