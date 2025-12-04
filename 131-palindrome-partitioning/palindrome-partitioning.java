class Solution {
    static int[][] dp = new int[18][18];
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            Arrays.fill(dp[i], -1);
        }
        palindrome(0, s, res, new ArrayList<>());
        return res;
    }
    private static void palindrome(int ind, String str, List<List<String>> res, List<String> list) {
        if(ind == str.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<str.length();i++) {
            if(check(str, ind, i)){
                list.add(str.substring(ind, i+1));
                palindrome(i+1, str, res, list);
                list.remove(list.size()-1);
            }
        }
    }
    private static boolean check(String str, int l, int r) {
        int left = l;
        int right = r;
        if(dp[l][r]!=-1) return dp[l][r] == 1;
        while(left<=right) {
            if(str.charAt(left)!=str.charAt(right)) {
                dp[l][r] = 0;
                return false;
            }
            left++;
            right--;
        }
        dp[l][r] = 1;
        return true;
    }
}