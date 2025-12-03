class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> str = new ArrayList<>();
        String[] arr = {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits == null || digits.isEmpty()) return str;
        backtrack(str, arr, "", 0, digits);
        return str;
    }
    private static void backtrack(List<String> str, String[] arr, String s, int ind, String digits) {
        if(ind == digits.length()) {
            str.add(s);
            return;
        }
        String letters = arr[digits.charAt(ind) - '0'];
        for(char c : letters.toCharArray()) {
            backtrack(str, arr, s+c,ind+1,digits);
        }
    }
}