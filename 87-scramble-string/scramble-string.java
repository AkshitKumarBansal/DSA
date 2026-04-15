class Solution {
    Map<String, Boolean> map;
    public boolean isScramble(String s1, String s2) {
        map = new HashMap<>();
        return solve(s1, s2);
    }
    private boolean solve(String s1, String s2) {
        int n = s1.length();
        if(s1.equals(s2)) return true;
        String key = s1+" "+s2;
        if(map.containsKey(key)) return map.get(key);
        boolean flag = false;
        for(int i=1;i<n;i++) {
            boolean flag1 = false;
            boolean flag2 = false;
            if(solve(s1.substring(0,i), s2.substring(0,i)) && solve(s1.substring(i,n), s2.substring(i,n))) flag1 = true;
            if(solve(s1.substring(0,i), s2.substring(n-i,n)) && solve(s1.substring(i,n), s2.substring(0,n-i))) flag2 = true;
            if(flag1 || flag2) {
                flag = true;
                break;
            }
        }
        map.put(key, flag);
        return flag;
    }
}