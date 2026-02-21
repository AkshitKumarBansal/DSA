class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            list.get(u).add(i);
            list.get(v).add(i);
        }
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.dist, b.dist));
        pq.offer(new Pair(0,0));
        dist[0] = 0;
        ways[0] = 1;
        while(!pq.isEmpty()) {
            Pair node = pq.poll();
            int e = node.edge;
            long d = node.dist;
            if(d>dist[e]) continue;
            for(int x:list.get(e)) {
                int u = roads[x][0];
                int v = roads[x][1];
                int wt = roads[x][2];
                int next = (u == e) ? v : u;
                if(d+wt < dist[next]) {
                    dist[next] = d+wt;
                    ways[next] = ways[e];
                    pq.offer(new Pair(next, d+wt));
                }
                else if(d+wt == dist[next]) {
                    ways[next] = (ways[next] + ways[e]) % MOD;
                }
            }
        }
        return (int)(ways[n - 1] % MOD);
    }
}
class Pair {
    int edge;
    long dist;
    public Pair(int edge, long dist) {
        this.edge = edge;
        this.dist = dist;
    }
}