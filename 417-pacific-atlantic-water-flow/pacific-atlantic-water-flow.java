import java.util.*;

class Solution {
    int[][] pacificDP;
    int[][] atlanticDP;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        pacificDP  = new int[m][n]; // 0 = unvisited, 1 = true, -1 = false
        atlanticDP = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // ✅ FIX: pass boolean[m][n] (2D) and signature also takes boolean[][]
                boolean p = pO(i, j, m, n, heights, new boolean[m][n]);
                boolean a = aO(i, j, m, n, heights, new boolean[m][n]);
                if (p && a) result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    // ✅ visiting is boolean[][] (2D) — matches new boolean[m][n] at call site
    private boolean pO(int i, int j, int m, int n, int[][] h, boolean[][] vis) {
        if (i < 0 || j < 0) return true;   // off Pacific edge (top/left)
        if (i >= m || j >= n) return false; // off Atlantic edge

        if (pacificDP[i][j] != 0) return pacificDP[i][j] == 1;

        if (vis[i][j]) return false; // cycle guard — safe for OR logic

        if (i == 0 || j == 0) {     // on Pacific border
            pacificDP[i][j] = 1;
            return true;
        }

        vis[i][j] = true;
        int cur = h[i][j];
        boolean res = false;

        if (i-1 >= 0 && cur >= h[i-1][j]) res |= pO(i-1, j, m, n, h, vis);
        if (i+1 < m  && cur >= h[i+1][j]) res |= pO(i+1, j, m, n, h, vis);
        if (j-1 >= 0 && cur >= h[i][j-1]) res |= pO(i, j-1, m, n, h, vis);
        if (j+1 < n  && cur >= h[i][j+1]) res |= pO(i, j+1, m, n, h, vis);

        vis[i][j] = false;
        if (res) pacificDP[i][j] = 1; // only cache true — don't cache false from cycle
        return res;
    }

    private boolean aO(int i, int j, int m, int n, int[][] h, boolean[][] vis) {
        if (i >= m || j >= n) return true;  // off Atlantic edge (bottom/right)
        if (i < 0  || j < 0) return false;  // off Pacific edge

        if (atlanticDP[i][j] != 0) return atlanticDP[i][j] == 1;

        if (vis[i][j]) return false; // cycle guard

        if (i == m-1 || j == n-1) {  // on Atlantic border
            atlanticDP[i][j] = 1;
            return true;
        }

        vis[i][j] = true;
        int cur = h[i][j];
        boolean res = false;

        if (i-1 >= 0 && cur >= h[i-1][j]) res |= aO(i-1, j, m, n, h, vis);
        if (i+1 < m  && cur >= h[i+1][j]) res |= aO(i+1, j, m, n, h, vis);
        if (j-1 >= 0 && cur >= h[i][j-1]) res |= aO(i, j-1, m, n, h, vis);
        if (j+1 < n  && cur >= h[i][j+1]) res |= aO(i, j+1, m, n, h, vis);

        vis[i][j] = false;
        if (res) atlanticDP[i][j] = 1;
        return res;
    }
}