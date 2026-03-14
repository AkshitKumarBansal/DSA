class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return solve(set, s, 0, memo);
    }
    private boolean solve(Set<String> set, String s, int ind, Boolean[] memo) {
        if(ind == s.length()) return true;
        if(memo[ind] != null) return memo[ind];
        for(int i=ind+1;i<=s.length();i++) {
            if(set.contains(s.substring(ind, i)) && solve(set, s, i, memo)) {
                return memo[ind] = true;
            }
        }
        return memo[ind] = false;
    }
}