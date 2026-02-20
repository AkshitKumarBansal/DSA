class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++) {
            int u = times[i][0]-1;
            list.get(u).add(i);
        }
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[k-1] = 0;
        Queue<Triplet> queue = new LinkedList<>();
        queue.offer(new Triplet(k-1, 0));
        while(!queue.isEmpty()) {
            Triplet node = queue.poll();
            int s = node.start;
            int t = node.time;
            if(t>arr[s]) continue;
            for(int x:list.get(s)) {
                int v = times[x][1]-1;
                int wt = times[x][2];
                if(arr[v]>(wt+t)) {
                    arr[v] = wt+t;
                    queue.offer(new Triplet(v, wt+t));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int x:arr) max = Math.max(x, max);
        return (max == Integer.MAX_VALUE) ? -1 : max;
    }
}
class Triplet {
    int start;
    int time;
    public Triplet(int start, int time) {
        this.start = start;
        this.time = time;
    }
}