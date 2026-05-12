class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) ->
                    (tasks[b][1] - tasks[b][0]) -
                    (tasks[a][1] - tasks[a][0])
                );        
        int value = 0;
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(tasks[idx[i]][1] > value) {
                int diff = tasks[idx[i]][1] - value;
                value += diff;
                ans += diff;
            }
            if(tasks[idx[i]][0] > value) {
                int diff = tasks[idx[i]][0] - value;
                value += diff;
                ans += diff;
            }
            value -= tasks[idx[i]][0];
        }
        return ans;
    }
}