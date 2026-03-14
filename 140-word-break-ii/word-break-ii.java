class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        solve(s, set, 0, new StringBuilder(), result);
        return result;
    }
    private void solve(String s, Set<String> set, int ind, StringBuilder sb, List<String> res) {
        if(ind == s.length()) {
            res.add(sb.toString().trim());
            return;
        }
        for(int i=ind;i<=s.length();i++) {
            if(set.contains(s.substring(ind, i))) {
                int len = sb.length();
                sb.append(s.substring(ind, i)).append(" ");
                solve(s, set, i, sb, res);
                sb.setLength(len);
            }
        }
    }
}