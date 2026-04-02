class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                boolean[][] visited1 = new boolean[m][n];
                boolean[][] visited2 = new boolean[m][n];
                boolean p = pO(i, j, m, n, heights, visited1);
                boolean a = aO(i, j, m, n, heights, visited2);
                if(p && a) result.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return result;
    }
    private boolean pO(int i, int j, int m, int n, int[][] heights, boolean[][] visited) {
        if(i<0 || j<0) return true;
        if(i>=m || j>=n || visited[i][j]) return false;
        visited[i][j] = true;
        if(i == 0 || j == 0) return true;
        boolean left = false, right = false, top = false, bottom = false;
        if(i-1 >= 0 && heights[i][j] >= heights[i-1][j]) top    = pO(i-1, j, m, n, heights, visited);
        if(i+1 < m  && heights[i][j] >= heights[i+1][j]) bottom = pO(i+1, j, m, n, heights, visited);
        if(j-1 >= 0 && heights[i][j] >= heights[i][j-1]) left   = pO(i, j-1, m, n, heights, visited);
        if(j+1 < n  && heights[i][j] >= heights[i][j+1]) right  = pO(i, j+1, m, n, heights, visited);
        return left || right || top || bottom;
    }
    private boolean aO(int i, int j, int m, int n, int[][] heights, boolean[][] visited) {
        if(i>=m || j>=n) return true;
        if(i<0 || j<0 || visited[i][j]) return false;
        visited[i][j] = true;
        if(i == m-1 || j == n-1) return true;
        boolean left = false, right = false, top = false, bottom = false;
        if(i-1 >= 0 && heights[i][j] >= heights[i-1][j]) top    = aO(i-1, j, m, n, heights, visited);
        if(i+1 < m  && heights[i][j] >= heights[i+1][j]) bottom = aO(i+1, j, m, n, heights, visited);
        if(j-1 >= 0 && heights[i][j] >= heights[i][j-1]) left   = aO(i, j-1, m, n, heights, visited);
        if(j+1 < n  && heights[i][j] >= heights[i][j+1]) right  = aO(i, j+1, m, n, heights, visited);
        return left || right || top || bottom;
    }
    
}