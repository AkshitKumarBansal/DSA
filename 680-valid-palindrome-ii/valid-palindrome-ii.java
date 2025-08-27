class Solution {
    public boolean validPalindrome(String s) {
        int count=0;
        int n1 = 0;
        int n2 = s.length()-1;
        while(n1 <= n2){
            if(s.charAt(n1) != s.charAt(n2)){
                return palindrome(s , n1, n2-1) || palindrome(s, n1+1, n2);
            }
            n1++;
            n2--;
        }
        return true;
    }
    private boolean palindrome(String s, int i, int j){
    while(i <= j){
        if(s.charAt(i) != s.charAt(j)){
            return false;
        }
        i++;
        j--;
    }
    return true;
}
}