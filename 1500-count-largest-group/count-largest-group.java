class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++) {
            int x = i;
            int sum = 0;
            while(x!=0) {
                sum += x%10;
                x /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        int max = 0;
        for(int x : map.values()) max = Math.max(max, x);
        int count = 0;
        for(int x : map.values()) if(max == x) count++;
        return count;
    }
}