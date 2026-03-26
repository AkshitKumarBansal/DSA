class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=lowLimit;i<=highLimit;i++) {
            int x = i;
            int sum = 0;
            while(x!=0) {
                sum += x%10;
                x /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
            max = Math.max(map.get(sum), max);
        }
        return max;
    }
}