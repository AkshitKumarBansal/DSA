class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        for(int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++) {
            int u = flights[i][0];
            list.get(u).add(i);
        }
        Queue<Triplet> queue = new LinkedList<>();
        queue.add(new Triplet(src, 0, 0));
        minCost[src] = 0;
        while(!queue.isEmpty()) {
            Triplet node = queue.poll();
            int s = node.src;
            int c = node.cost;
            int st = node.steps;
            if(st>k) continue;
            for(int x:list.get(s)) {
                int v = flights[x][1];
                int wt = flights[x][2];
                if(c + wt < minCost[v]) {
                    minCost[v] = c + wt;
                    queue.offer(new Triplet(v, c + wt, st + 1));
                }
            }
        }
        return (minCost[dst] == Integer.MAX_VALUE) ? -1 : minCost[dst];
    }
}
class Triplet {
    int src;
    int cost;
    int steps;
    public Triplet(int src, int cost, int steps) {
        this.src = src;
        this.cost = cost;
        this.steps = steps;
    }
}