class Solution {
    public long maxPoints(int[] arr1, int[] arr2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        // Queue<Integer> q = new LinkedList<>();
        int count = 0;
        long score = 0;
        int n = arr1.length;
        for(int i=0;i<n;i++) {
            if(arr1[i]>arr2[i])  {
                count++;
                score += arr1[i];
            } else {
                pq.offer(arr2[i]-arr1[i]);
                score += arr2[i];
            }
        }
        System.out.println(count);
        int x = 0;
        if(count < k) {
            x = k-count;
        }
        System.out.println(x);
        while(x!=0 && !pq.isEmpty()) {
            System.out.println(pq.peek());
            score -= pq.poll();
            x--;
        }
        return score;
    }
}