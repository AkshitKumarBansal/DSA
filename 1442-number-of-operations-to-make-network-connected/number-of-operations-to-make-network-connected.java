class Solution {
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }
        for(int[] b:connections) {
            int u = b[0];
            int v = b[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                visited[i] = true;
                count++;
                q.offer(i);
                while(!q.isEmpty()) {
                    int node = q.poll();
                    for(int c:list.get(node)) {
                        if(!visited[c]) {
                            visited[c]=true;
                            q.offer(c);
                        }
                    }
                }
            }
        }
        System.out.println(count+" "+edges);
        if(count == 1) return 0;
        if(edges >= n-1) return count-1;
        return -1;
    }
}