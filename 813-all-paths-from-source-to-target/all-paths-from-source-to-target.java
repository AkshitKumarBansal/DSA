class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int n = graph.length;
        dfs(0, graph, n, result, list);
        return result;
    }
    private void dfs(int ind, int[][] graph, int n, List<List<Integer>> result, List<Integer> list) {
        if(ind == n-1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<graph[ind].length;i++) {
            list.add(graph[ind][i]);
            dfs(graph[ind][i], graph, n, result, list);
            list.remove(list.size()-1);
        }
    }
}