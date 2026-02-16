class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1) return -1;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<Triplet> queue = new LinkedList<>();
        queue.offer(new Triplet(0,0,1));
        vis[0][0] = true;
        while(!queue.isEmpty()) {
            int level = queue.size();
            for(int i=0;i<level;i++) {
                Triplet node = queue.poll();
                int r = node.row;
                int c = node.col;
                int d = node.dist;
                if(r == grid.length-1 && c == grid[0].length-1) return d;
                // Down-Right
                if(r+1 < grid.length && c+1 < grid[0].length && grid[r+1][c+1] == 0 && !vis[r+1][c+1]) {
                    queue.offer(new Triplet(r+1, c+1, d+1));
                    vis[r+1][c+1] = true;
                }
                // Down
                if(r+1 < grid.length && grid[r+1][c] == 0 && !vis[r+1][c]) {
                    queue.offer(new Triplet(r+1, c, d+1));
                    vis[r+1][c] = true;
                }
                // Right
                if(c+1 < grid[0].length && grid[r][c+1] == 0 && !vis[r][c+1]) {
                    queue.offer(new Triplet(r, c+1, d+1));
                    vis[r][c+1] = true;
                }
                // Up-Right
                if(r-1 >= 0 && c+1 < grid[0].length && grid[r-1][c+1] == 0 && !vis[r-1][c+1]) {
                    queue.offer(new Triplet(r-1, c+1, d+1));
                    vis[r-1][c+1] = true;
                }
                // Left
                if(c-1 >= 0 && grid[r][c-1] == 0 && !vis[r][c-1]) {
                    queue.offer(new Triplet(r, c-1, d+1));
                    vis[r][c-1] = true;
                }
                // Up
                if(r-1 >= 0 && grid[r-1][c] == 0 && !vis[r-1][c]) {
                    queue.offer(new Triplet(r-1, c, d+1));
                    vis[r-1][c] = true;
                }
                // Down-Left
                if(r+1 < grid.length && c-1 >= 0 && grid[r+1][c-1] == 0 && !vis[r+1][c-1]) {
                    queue.offer(new Triplet(r+1, c-1, d+1));
                    vis[r+1][c-1] = true;
                }
                // Up-Left
                if(r-1 >= 0 && c-1 >= 0 && grid[r-1][c-1] == 0 && !vis[r-1][c-1]) {
                    queue.offer(new Triplet(r-1, c-1, d+1));
                    vis[r-1][c-1] = true;
                }

            }
        }
        return -1;
    }
}

class Triplet {
    public int row;
    public int col;
    public int dist;
    public Triplet(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}