import java.util.*;

class Solution {

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int[] e : edges) {
            graph[e[0]].add(new Edge(e[1], e[2]));
            indegree[e[1]]++;

            low = Math.min(low, e[2]);
            high = Math.max(high, e[2]);
        }

        // Topological Order (same for every binary search iteration)
        int[] topo = new int[n];
        Queue<Integer> q = new LinkedList<>();

        int[] indeg = indegree.clone();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0)
                q.offer(i);
        }

        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (Edge e : graph[u]) {
                if (--indeg[e.to] == 0)
                    q.offer(e.to);
            }
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(mid, graph, topo, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canReach(int minEdge,
                             List<Edge>[] graph,
                             int[] topo,
                             boolean[] online,
                             long k,
                             int n) {

        long INF = Long.MAX_VALUE / 4;

        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF)
                continue;

            // Intermediate nodes must be online.
            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (Edge e : graph[u]) {

                if (e.cost < minEdge)
                    continue;

                int v = e.to;

                if (v != n - 1 && !online[v])
                    continue;

                if (dist[u] + e.cost < dist[v]) {
                    dist[v] = dist[u] + e.cost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}