class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : deck) map.put(x, map.getOrDefault(x, 0)+1);
        int num = map.get(deck[0]);
        for(int x : map.values()) {
            int ans = gcd(num, x);
            num = ans;
        }
        return num>=2;
    }
    private int gcd(int a, int b) {
        if(b%a==0) return a;
        return gcd(b%a, a);
    }
}