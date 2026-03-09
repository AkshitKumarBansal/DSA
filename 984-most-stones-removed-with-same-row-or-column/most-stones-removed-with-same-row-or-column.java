class Solution {
    public int removeStones(int[][] stones) {
        int components = 0;
        boolean[] visited = new boolean[stones.length];
        for(int i=0;i<stones.length;i++) {
            if(!visited[i]) {
                dfs(i, stones, visited);
                components++;
            }
        }
        return stones.length-components;
    }
    private void dfs(int i, int[][] stones, boolean[] visited) {
        visited[i] = true;
        for(int j=0;j<stones.length;j++) {
            if(!visited[j] && (stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1])) {
                dfs(j, stones, visited);
            }
        }
    }
}