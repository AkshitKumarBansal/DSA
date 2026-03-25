class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int[] d : dominoes) {
            int x = Math.min(d[0], d[1])*10 + Math.max(d[0], d[1]);
            int freq = map.getOrDefault(x,0);
            count += freq;
            map.put(x, freq+1);
        }
        return count;
    }
}