class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean flag = false;
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                if(dfs(i, adj, visited, pathVisited)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int ind, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[ind] = true;
        pathVisited[ind] = true;
        for (int neighbor : adj.get(ind)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, pathVisited)) return true;
            } 
            else if (pathVisited[neighbor]) {
                return true;
            }
        }
        pathVisited[ind] = false;
        return false;
    }
}