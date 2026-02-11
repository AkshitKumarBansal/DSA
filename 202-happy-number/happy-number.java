class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1) {
            int newNum = 0;
            while(n != 0) {
                newNum += Math.pow((n%10), 2);
                n /= 10;
            }
            n = newNum;
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }
}