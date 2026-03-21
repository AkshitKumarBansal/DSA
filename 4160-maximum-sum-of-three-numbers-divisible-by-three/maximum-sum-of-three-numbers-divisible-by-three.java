class Solution {
    public int maximumSum(int[] nums) {
        PriorityQueue<Integer> pq0 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i]%3==0) pq0.offer(nums[i]);
            else if(nums[i]%3==1) pq1.offer(nums[i]);
            else pq2.offer(nums[i]);
        }
        int max = 0;
        int pqn0 = 0;
        if(pq0.size()>=3) {
            pqn0 = pq0.poll();
            int a = pq0.poll();
            int b = pq0.poll();
            max = Math.max(pqn0+a+b, max);
        } else if(pq0.size()>=1) {
            pqn0 = pq0.poll();
        }
        System.out.println(pqn0 +" "+max);
        int pqn1 = 0;
        if(pq1.size()>=3) {
            pqn1 = pq1.poll();
            int a = pq1.poll();
            int b = pq1.poll();
            max = Math.max(pqn1+a+b, max);
        } else if(pq1.size()>=1) {
            pqn1 = pq1.poll();
        }
        int pqn2 = 0;
        if(pq2.size()>=3) {
            pqn2 = pq2.poll();
            int a = pq2.poll();
            int b = pq2.poll();
            max = Math.max(pqn2+a+b, max);
        } else if(pq2.size()>=1) {
            pqn2 = pq2.poll();
        }
        
        if(pqn0!=0 && pqn1!=0 && pqn2!=0) max = Math.max(pqn0+pqn1+pqn2, max);
        return max;
    }
}