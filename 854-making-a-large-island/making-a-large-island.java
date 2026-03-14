class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        Map<Integer,Integer> map = new HashMap<>();
        int id = 2;
        int max = 0;

        // Step 1: label islands
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 1){

                    int size = dfs(grid,i,j,id);
                    map.put(id,size);
                    max = Math.max(max,size);
                    id++;
                }
            }
        }

        // Step 2: check flipping 0
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 0){

                    Set<Integer> set = new HashSet<>();
                    int size = 1;

                    for(int[] d:dir){

                        int r = i + d[0];
                        int c = j + d[1];

                        if(r>=0 && c>=0 && r<n && c<n && grid[r][c] > 1){

                            int islandId = grid[r][c];

                            if(!set.contains(islandId)){
                                size += map.get(islandId);
                                set.add(islandId);
                            }
                        }
                    }

                    max = Math.max(max,size);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid,int r,int c,int id){

        int n = grid.length;

        if(r<0 || c<0 || r>=n || c>=n || grid[r][c] != 1) return 0;

        grid[r][c] = id;

        int size = 1;

        size += dfs(grid,r+1,c,id);
        size += dfs(grid,r-1,c,id);
        size += dfs(grid,r,c+1,id);
        size += dfs(grid,r,c-1,id);

        return size;
    }
}