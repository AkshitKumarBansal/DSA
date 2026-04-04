class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0;
        int cost = 0;
        int left = 0;
        for(int right = 0;right<s.length();right++) {
            cost += Math.abs(s.charAt(right)-t.charAt(right));
            while(left <= right && maxCost < cost) {
                cost -= Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}