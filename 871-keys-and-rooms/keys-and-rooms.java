class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for(int i=0;i<rooms.get(0).size();i++) {
            if(!visited[rooms.get(0).get(i)]) {
                dfs(rooms, rooms.get(0).get(i), visited);
            }
        }
        for(int i=0;i<n;i++) {
            if(!visited[i]) return false;
        }
        return true;
    }
    private void dfs(List<List<Integer>> list, int ind, boolean[] visited) {
        visited[ind] = true;
        for(int i=0;i<list.get(ind).size();i++) {
            if(!visited[list.get(ind).get(i)]) {
                dfs(list, list.get(ind).get(i), visited);
            }
        }
    }
}