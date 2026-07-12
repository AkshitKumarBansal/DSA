class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words) {
            if(check(s)) return s;
        }
        return "";
    }
    private boolean check(String s) {
        int left = 0, right = s.length()-1;
        while(left<right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}