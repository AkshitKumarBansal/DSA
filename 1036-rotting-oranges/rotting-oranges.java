class Triplet {
    int row;
    int col;
    int time;
    public Triplet(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<Triplet> q = new LinkedList<>();
        int count = 0;
        // int[][] arr = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==2) {
                    q.offer(new Triplet(i, j, 0));
                } else if(grid[i][j]==1) {
                    count++;
                }
            }
        }
        int min = 0;
        while(!q.isEmpty()) {
            Triplet ele = q.poll();
            for(int[] x : directions) {
                int r = ele.row + x[0];
                int c = ele.col + x[1];
                if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1) {
                    grid[r][c] = 2;
                    count--;
                    min = ele.time+1;
                    q.offer(new Triplet(r, c, ele.time+1));
                }
            }
        }
        return (count!=0) ? -1 : min;
    }
}